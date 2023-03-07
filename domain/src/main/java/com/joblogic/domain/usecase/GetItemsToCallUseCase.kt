package com.joblogic.domain.usecase

import com.joblogic.domain.model.Person
import com.joblogic.domain.repo.TransactionRepo
import javax.inject.Inject
import com.joblogic.domain.common.Result

class GetItemsToCallUseCase @Inject constructor(private val transactionRepo: TransactionRepo) {
    suspend operator fun invoke(): Result<List<Person>> {
        return transactionRepo.getItemsToCall()
    }
}