package com.joblogic.domain.usecase

import com.joblogic.domain.model.Item
import com.joblogic.domain.repo.TransactionRepo
import javax.inject.Inject
import com.joblogic.domain.common.Result

class GetItemsToBuyUseCase @Inject constructor(private val transactionRepo: TransactionRepo) {
    suspend operator fun invoke(): Result<List<Item>> {
        return transactionRepo.getItemsToBuy()
    }
}