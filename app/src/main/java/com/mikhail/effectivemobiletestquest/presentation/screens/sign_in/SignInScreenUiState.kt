package com.mikhail.effectivemobiletestquest.presentation.screens.sign_in

data class SignInScreenUiState(
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val isError: Boolean
) {
    companion object {
        val default = SignInScreenUiState(
            name = "",
            surname = "",
            phoneNumber = "",
            isError = true
        )
    }
}