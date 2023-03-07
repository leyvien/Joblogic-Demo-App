package com.joblogic.presentation.screen.calllisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.joblogic.domain.common.Result
import com.joblogic.domain.usecase.GetItemsToCallUseCase
import com.joblogic.presentation.base.BaseViewModel
import com.joblogic.presentation.screen.calllisting.model.CallListingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CallListingViewModel @Inject constructor(private val getItemsToCallUseCase: GetItemsToCallUseCase) :
    BaseViewModel() {
    private val _callItemsUiState: MutableLiveData<CallListingUiState> = MutableLiveData()
    val callItemsUiState: LiveData<CallListingUiState> = _callItemsUiState

    init {
        getItemsToCall()
    }

    private fun getItemsToCall() {
        viewModelScope.launch {
            _callItemsUiState.value = CallListingUiState.Loading
            when (val result = getItemsToCallUseCase.invoke()) {
                is Result.Success ->
                    _callItemsUiState.value = CallListingUiState.Success(result.data)
                is Result.Failure ->
                    _callItemsUiState.value = CallListingUiState.Error(result.errorMsg)
            }
        }
    }
}