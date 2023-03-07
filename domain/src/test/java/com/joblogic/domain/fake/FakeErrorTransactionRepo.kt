package com.joblogic.domain.fake

import com.joblogic.domain.common.Result
import com.joblogic.domain.model.Item
import com.joblogic.domain.model.Person
import com.joblogic.domain.repo.TransactionRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeErrorTransactionRepo : TransactionRepo {
    override suspend fun getItemsToCall(): Result<List<Person>> {
        return Result.Failure("Error")
    }

    override suspend fun getItemsToBuy(): Result<List<Item>> {
        return Result.Failure("Error")
    }

    override fun getItemsToSell(): Flow<List<Item>> = flow {
        emit(emptyList())
    }
}