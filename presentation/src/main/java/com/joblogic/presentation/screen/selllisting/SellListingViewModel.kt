package com.joblogic.presentation.screen.selllisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.joblogic.domain.usecase.GetItemsToSellUseCase
import com.joblogic.presentation.base.BaseViewModel
import com.joblogic.presentation.screen.selllisting.model.SellListingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SellListingViewModel @Inject constructor(private val getItemsToSellUseCase: GetItemsToSellUseCase) :
    BaseViewModel() {
    private val _sellItemsUiState: MutableLiveData<SellListingUiState> = MutableLiveData()
    val sellItemsUiState: LiveData<SellListingUiState> = _sellItemsUiState

    init {
        getItemsToSell()
    }

    private fun getItemsToSell() {
        viewModelScope.launch {
            getItemsToSellUseCase
                .invoke()
                .onStart {
                    _sellItemsUiState.value = SellListingUiState.Loading
                }
                .catch {
                    _sellItemsUiState.value = SellListingUiState.Error(it.message!!)
                }
                .collect {
                    _sellItemsUiState.value = SellListingUiState.Success(it)
                }
        }
    }
}