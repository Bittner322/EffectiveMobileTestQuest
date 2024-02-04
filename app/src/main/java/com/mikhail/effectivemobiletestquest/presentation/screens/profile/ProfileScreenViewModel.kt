package com.mikhail.effectivemobiletestquest.presentation.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.effectivemobiletestquest.data.database.models.RegistrationModel
import com.mikhail.effectivemobiletestquest.data.repositories.ProductsRepository
import com.mikhail.effectivemobiletestquest.data.repositories.RegistrationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,
    private val registrationRepository: RegistrationRepository
) : ViewModel() {

    val userInfo = registrationRepository.getUserData()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = RegistrationModel(
                name = "",
                surname = "",
                phoneNumber = ""
            )
        )

    val favoritesCount = productsRepository.getFavoritesCount()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = 0
        )
}