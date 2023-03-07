package com.joblogic.domain.fake

import com.joblogic.domain.common.Result
import com.joblogic.domain.factory.TestData
import com.joblogic.domain.model.Item
import com.joblogic.domain.model.Person
import com.joblogic.domain.repo.TransactionRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeSuccessTransactionRepo: TransactionRepo {
    override suspend fun getItemsToCall(): Result<List<Person>> {
        return Result.Success(TestData.callListingItems)
    }

    override suspend fun getItemsToBuy(): Result<List<Item>> {
        return Result.Success(TestData.buyListingItems)
    }

    override fun getItemsToSell(): Flow<List<Item>> = flow {
        emit(TestData.sellListingItems)
    }
}