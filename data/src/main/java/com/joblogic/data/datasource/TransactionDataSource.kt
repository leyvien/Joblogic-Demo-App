package com.joblogic.data.datasource

import com.joblogic.data.datasource.remote.TransactionApi
import com.joblogic.data.datasource.remote.model.ItemResponse
import com.joblogic.data.datasource.remote.model.PersonResponse
import com.joblogic.data.datasource.local.TransactionDatabase
import com.joblogic.data.datasource.local.model.ItemEntity
import kotlinx.coroutines.flow.Flow

interface TransactionDataSource {
    suspend fun getItemsToCall(): List<PersonResponse>
    suspend fun getItemsToBuy(): List<ItemResponse>
    fun getItemsToSell(): Flow<List<ItemEntity>>
}

class TransactionDataSourceImpl(
    private val transactionDatabase: TransactionDatabase,
    private val transactionApi: TransactionApi,
) : TransactionDataSource {
    override suspend fun getItemsToCall(): List<PersonResponse> {
        return transactionApi.fetchItemsToCall()
    }

    override suspend fun getItemsToBuy(): List<ItemResponse> {
        return transactionApi.fetchItemsToBuy()
    }

    override fun getItemsToSell(): Flow<List<ItemEntity>> =
        transactionDatabase.transactionDao().getItemsToSell()

}