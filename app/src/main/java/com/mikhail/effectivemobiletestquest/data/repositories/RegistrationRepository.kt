package com.mikhail.effectivemobiletestquest.data.repositories

import android.content.SharedPreferences
import com.mikhail.effectivemobiletestquest.data.database.AppDatabase
import com.mikhail.effectivemobiletestquest.data.database.models.RegistrationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val isUserLoggedSharedPref = "isLogged"

class RegistrationRepository @Inject constructor(
    private val database: AppDatabase,
    private val sharedPreferences: SharedPreferences
) {
    suspend fun register(
        name: String,
        surname: String,
        phoneNumber: String
    ) {
        withContext(Dispatchers.IO) {
            database.registrationDao().add(
                registrationModel = RegistrationModel(
                    name = name,
                    surname = surname,
                    phoneNumber = phoneNumber
                )
            )
        }
    }

    fun setIsUserLogged() {
        with(sharedPreferences.edit()) {
            putBoolean(isUserLoggedSharedPref, true)
            commit()
        }
    }

    fun checkIsUserLogged(): Boolean {
        return sharedPreferences.getBoolean(isUserLoggedSharedPref, false)
    }

    fun getUserData(): Flow<RegistrationModel> {
        return database.registrationDao().getRegistrationData()
            .flowOn(Dispatchers.IO)
    }

    fun clearSharedPrefs() {
        with(sharedPreferences.edit()) {
            clear()
            commit()
        }
    }

    suspend fun clearRegistrationData() {
        withContext(Dispatchers.IO) {
            database.registrationDao().clearRegistrationData()
        }
    }
}