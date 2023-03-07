package com.joblogic.presentation.screen.selllisting.model

import com.joblogic.domain.model.Item

sealed interface SellListingUiState {
    object Loading : SellListingUiState
    data class Success(val data: List<Item>) : SellListingUiState
    data class Error(val message: String) : SellListingUiState
}