package com.joblogic.data.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase.Callback
import androidx.sqlite.db.SupportSQLiteDatabase
import com.joblogic.data.datasource.local.TransactionDatabase
import com.joblogic.data.datasource.local.dao.TransactionDao
import com.joblogic.data.datasource.local.model.populateSellItemsData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Provider
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalDBModule {
    class LocalDBCallback (
        private val provider: Provider<TransactionDao>
    ) : Callback() {

        private val applicationScope = CoroutineScope(SupervisorJob())

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            applicationScope.launch(Dispatchers.IO) {
                populateDatabase()
            }
        }

        private suspend fun populateDatabase() {
            provider.get().insertItemsToSell(populateSellItemsData())
        }
    }

    @Singleton
    @Provides
    fun provideAppDatabase(
        app: Application,
        transactionDao: Provider<TransactionDao>,
    ): TransactionDatabase {
        return Room.databaseBuilder(app, TransactionDatabase::class.java, "transaction-db")
            .addCallback(LocalDBCallback(transactionDao))
            .build()
    }

    @Singleton
    @Provides
    fun provideTransactionDao(transactionDatabase: TransactionDatabase) =
        transactionDatabase.transactionDao()

}


