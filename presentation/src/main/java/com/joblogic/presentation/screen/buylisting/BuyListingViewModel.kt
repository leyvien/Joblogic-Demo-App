package com.joblogic.presentation.screen.buylisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.joblogic.domain.usecase.GetItemsToBuyUseCase
import com.joblogic.presentation.base.BaseViewModel
import com.joblogic.presentation.screen.buylisting.model.BuyListingUiState
import com.joblogic.domain.common.Result.Success
import com.joblogic.domain.common.Result.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuyListingViewModel @Inject constructor(private val getItemsToBuyUseCase: GetItemsToBuyUseCase) :
    BaseViewModel() {
    private val _buyItemsUiState: MutableLiveData<BuyListingUiState> = MutableLiveData()
    val buyItemsUiState: LiveData<BuyListingUiState> = _buyItemsUiState

    init {
        getItemsToBuy()
    }

    private fun getItemsToBuy() {
        viewModelScope.launch {
            _buyItemsUiState.value = BuyListingUiState.Loading
            when (val result = getItemsToBuyUseCase.invoke()) {
                is Success ->
                    _buyItemsUiState.value = BuyListingUiState.Success(result.data)
                is Failure ->
                    _buyItemsUiState.value = BuyListingUiState.Error(result.errorMsg)
            }
        }
    }
}