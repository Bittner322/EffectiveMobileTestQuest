package com.mikhail.effectivemobiletestquest.presentation.main_activity

import androidx.lifecycle.ViewModel
import com.mikhail.effectivemobiletestquest.data.repositories.RegistrationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: RegistrationRepository
): ViewModel() {
    fun isUserLogged(): Boolean {
        return repository.checkIsUserLogged()
    }
}