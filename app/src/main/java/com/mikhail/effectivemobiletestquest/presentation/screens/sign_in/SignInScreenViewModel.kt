package com.mikhail.effectivemobiletestquest.presentation.screens.sign_in

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

private const val PhoneNumberLength = 11

@HiltViewModel
class SignInScreenViewModel @Inject constructor(

): ViewModel() {
    private val _uiAction = Channel<SignInAction>()
    val uiAction = _uiAction.receiveAsFlow()

    private val _uiState = MutableStateFlow(SignInScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    fun onNameChange(name: String) {
        _uiState.update {
            it.copy(name = name)
        }
        if (_uiState.value.name.isNotEmpty() &&
            _uiState.value.surname.isNotEmpty() &&
            _uiState.value.phoneNumber.length == PhoneNumberLength) {
            _uiState.update {
                it.copy(isError = false)
            }
        }
    }

    fun onSurnameChange(surname: String) {
        _uiState.update {
            it.copy(surname = surname)
        }
        if (_uiState.value.name.isNotEmpty() &&
            _uiState.value.surname.isNotEmpty() &&
            _uiState.value.phoneNumber.length == PhoneNumberLength) {
            _uiState.update {
                it.copy(isError = false)
            }
        }
    }

    fun onPhoneNumberChange(phoneNumber: String) {
        if (phoneNumber.isDigitsOnly()) {
            _uiState.update {
                it.copy(phoneNumber = phoneNumber)
            }
        }
        if (_uiState.value.name.isNotEmpty() &&
            _uiState.value.surname.isNotEmpty() &&
            _uiState.value.phoneNumber.length == PhoneNumberLength) {
            _uiState.update {
                it.copy(isError = false)
            }
        }
    }

    fun onSignInClick() {
        _uiAction.trySend(SignInAction.NavToMainScreen)
    }
}

sealed class SignInAction {
    data object NavToMainScreen: SignInAction()
}