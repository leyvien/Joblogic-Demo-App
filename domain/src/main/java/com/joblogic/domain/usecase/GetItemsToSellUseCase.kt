package com.joblogic.domain.usecase

import com.joblogic.domain.model.Item
import com.joblogic.domain.repo.TransactionRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemsToSellUseCase @Inject constructor(private val transactionRepo: TransactionRepo) {
    operator fun invoke(): Flow<List<Item>> {
        return transactionRepo.getItemsToSell()
    }
}