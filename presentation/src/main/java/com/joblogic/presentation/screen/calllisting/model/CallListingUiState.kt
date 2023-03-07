package com.joblogic.presentation.screen.calllisting.model

import com.joblogic.domain.model.Person

sealed interface CallListingUiState {
    object Loading : CallListingUiState
    data class Success(val data: List<Person>) : CallListingUiState
    data class Error(val message: String) : CallListingUiState
}