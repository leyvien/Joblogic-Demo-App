package com.joblogic.presentation.screen.buylisting.model

import com.joblogic.domain.model.Item

sealed interface BuyListingUiState {
    object Loading : BuyListingUiState
    data class Success(val data: List<Item>) : BuyListingUiState
    data class Error(val message: String) : BuyListingUiState
}