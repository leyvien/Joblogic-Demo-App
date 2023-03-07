package com.joblogic.data.di

import com.joblogic.data.TransactionRepoImpl
import com.joblogic.data.datasource.TransactionDataSource
import com.joblogic.data.datasource.TransactionDataSourceImpl
import com.joblogic.data.datasource.remote.TransactionApi
import com.joblogic.data.datasource.local.TransactionDatabase
import com.joblogic.domain.repo.TransactionRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideTransactionDataSource(
        api: TransactionApi,
        db: TransactionDatabase,
    ): TransactionDataSource {
        return TransactionDataSourceImpl(db, api)
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(transactionDataSource: TransactionDataSource): TransactionRepo {
        return TransactionRepoImpl(transactionDataSource)
    }
}

