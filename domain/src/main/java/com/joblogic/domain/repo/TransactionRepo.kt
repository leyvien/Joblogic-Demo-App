package com.joblogic.domain.repo

import com.joblogic.domain.model.Item
import com.joblogic.domain.model.Person
import kotlinx.coroutines.flow.Flow
import com.joblogic.domain.common.Result
interface TransactionRepo {
    suspend fun getItemsToCall(): Result<List<Person>>
    suspend fun getItemsToBuy(): Result<List<Item>>
    fun getItemsToSell(): Flow<List<Item>>
}