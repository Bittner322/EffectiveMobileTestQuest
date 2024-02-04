package com.mikhail.effectivemobiletestquest.data.repositories

import com.mikhail.effectivemobiletestquest.data.database.AppDatabase
import com.mikhail.effectivemobiletestquest.data.database.models.RegistrationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val database: AppDatabase
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

    fun getUserData(): Flow<RegistrationModel> {
        return database.registrationDao().getRegistrationData()
            .flowOn(Dispatchers.IO)
    }

    suspend fun clearRegistrationData() {
        withContext(Dispatchers.IO) {
            database.registrationDao().clearRegistrationData()
        }
    }
}