package com.mikhail.effectivemobiletestquest.presentation.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.effectivemobiletestquest.data.database.models.RegistrationModel
import com.mikhail.effectivemobiletestquest.data.repositories.ProductsRepository
import com.mikhail.effectivemobiletestquest.data.repositories.RegistrationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,
    private val registrationRepository: RegistrationRepository
) : ViewModel() {
    private val _uiAction = Channel<ProfileAction>()
    val uiAction = _uiAction.receiveAsFlow()

    val userInfo = registrationRepository.getUserData()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = RegistrationModel.default
        )

    val favoritesCount = productsRepository.getFavoritesCount()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = 0
        )

    fun onFavoritesClick() {
        _uiAction.trySend(ProfileAction.NavToFavorites)
    }

    fun onLogoutClick() {
        viewModelScope.launch {
            _uiAction.trySend(ProfileAction.NavToSignIn)
            productsRepository.clearProducts()
            registrationRepository.clearRegistrationData()
            registrationRepository.clearSharedPrefs()
        }
    }
}

sealed class ProfileAction {
    data object NavToFavorites: ProfileAction()
    data object NavToSignIn: ProfileAction()
}