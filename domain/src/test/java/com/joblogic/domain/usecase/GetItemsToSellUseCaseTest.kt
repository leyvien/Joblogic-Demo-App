package com.joblogic.domain.usecase

import com.google.common.truth.Truth
import com.joblogic.domain.factory.TestData
import com.joblogic.domain.fake.FakeErrorTransactionRepo
import com.joblogic.domain.fake.FakeSuccessTransactionRepo
import com.joblogic.domain.model.Item
import com.joblogic.domain.utils.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetItemsToSellUseCaseTest {

    @get: Rule
    val dispatcherRule = MainCoroutineRule()

    private lateinit var getItemsToSellUseCase: GetItemsToSellUseCase

    @Test
    fun getItemsToSellUseCase_should_return_success_result() = runTest {
        val repo = FakeSuccessTransactionRepo()
        getItemsToSellUseCase = GetItemsToSellUseCase(repo)

        val result = getItemsToSellUseCase.invoke().first()

        Truth.assertThat(result).isEqualTo(TestData.sellListingItems)
    }

    @Test
    fun getItemsToSellUseCase_should_return_empty_result() = runTest {
        val repo = FakeErrorTransactionRepo()
        getItemsToSellUseCase = GetItemsToSellUseCase(repo)

        val result = getItemsToSellUseCase.invoke().first()

        Truth.assertThat(result).isEqualTo(listOf<Item>())
    }
}