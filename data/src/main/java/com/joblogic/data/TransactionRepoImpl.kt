package com.joblogic.data

import com.joblogic.data.utils.safeApiCall
import com.joblogic.data.datasource.TransactionDataSource
import com.joblogic.data.datasource.remote.model.toDomainModel
import com.joblogic.data.datasource.local.model.toDomainModel
import com.joblogic.domain.common.Result
import com.joblogic.domain.model.Item
import com.joblogic.domain.model.Person
import com.joblogic.domain.repo.TransactionRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TransactionRepoImpl(
    private val transactionDataSource: TransactionDataSource,
) : TransactionRepo {
    override suspend fun getItemsToCall(): Result<List<Person>> = safeApiCall {
        transactionDataSource.getItemsToCall().map { it.toDomainModel() }
    }

    override suspend fun getItemsToBuy(): Result<List<Item>> = safeApiCall {
        transactionDataSource.getItemsToBuy().map { it.toDomainModel() }
    }

    override fun getItemsToSell(): Flow<List<Item>> =
        transactionDataSource.getItemsToSell()
            .map { sellItems -> sellItems.map { it.toDomainModel() } }

}