package com.joblogic.presentation.screen.calllisting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.joblogic.domain.usecase.GetItemsToCallUseCase
import com.joblogic.presentation.factory.TestData
import com.joblogic.presentation.utils.MainCoroutineRule
import org.junit.Rule
import org.junit.Test
import com.joblogic.domain.common.Result
import com.joblogic.presentation.screen.calllisting.model.CallListingUiState
import com.joblogic.presentation.utils.getOrAwaitValue
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest


@OptIn(ExperimentalCoroutinesApi::class)
class CallListingViewModelTest {

    @get: Rule
    val dispatcherRule = MainCoroutineRule()

    //for livedata
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val getItemsToCallUseCase: GetItemsToCallUseCase = mockk()
    private lateinit var viewmodel: CallListingViewModel

    @Test
    fun init_should_show_success_state() = runTest {
        coEvery { getItemsToCallUseCase.invoke() } returns Result.Success(TestData.callListingItems)

        viewmodel = CallListingViewModel(getItemsToCallUseCase)

        val result = viewmodel.callItemsUiState.getOrAwaitValue()

        assertThat(result).isEqualTo(CallListingUiState.Success(TestData.callListingItems))
    }

    @Test
    fun init_should_show_error_state() = runTest {
        coEvery { getItemsToCallUseCase.invoke() } returns Result.Failure("Error")

        viewmodel = CallListingViewModel(getItemsToCallUseCase)

        val result = viewmodel.callItemsUiState.getOrAwaitValue()

        assertThat(result).isEqualTo(CallListingUiState.Error("Error"))

    }
}