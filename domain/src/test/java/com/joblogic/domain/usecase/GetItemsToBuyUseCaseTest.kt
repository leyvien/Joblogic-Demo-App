package com.joblogic.domain.usecase

import com.google.common.truth.Truth
import com.joblogic.domain.factory.TestData
import com.joblogic.domain.fake.FakeErrorTransactionRepo
import com.joblogic.domain.fake.FakeSuccessTransactionRepo
import com.joblogic.domain.utils.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import com.joblogic.domain.common.Result

@OptIn(ExperimentalCoroutinesApi::class)
class GetItemsToBuyUseCaseTest{
    @get: Rule
    val dispatcherRule = MainCoroutineRule()

    private lateinit var getItemsToBuyUseCase: GetItemsToBuyUseCase

    @Test
    fun getItemsToBuyUseCaseTest_should_return_success_result() = runTest {
        val repo = FakeSuccessTransactionRepo()
        getItemsToBuyUseCase = GetItemsToBuyUseCase(repo)

        val result = getItemsToBuyUseCase.invoke()

        Truth.assertThat(result).isEqualTo(Result.Success(TestData.buyListingItems))
    }

    @Test
    fun getItemsToBuyUseCaseTest_should_return_error_result() = runTest {
        val repo = FakeErrorTransactionRepo()
        getItemsToBuyUseCase = GetItemsToBuyUseCase(repo)

        val result = getItemsToBuyUseCase.invoke()

        Truth.assertThat(result).isEqualTo(Result.Failure("Error"))
    }
}