package com.joblogic.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joblogic.data.datasource.local.dao.TransactionDao
import com.joblogic.data.datasource.local.model.ItemEntity

@Database(entities = [ItemEntity::class], exportSchema = false, version = 1)
abstract class TransactionDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}