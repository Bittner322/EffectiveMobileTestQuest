package com.mikhail.effectivemobiletestquest.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mikhail.effectivemobiletestquest.data.database.models.RegistrationModel

@Dao
interface RegistrationDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(registrationModel: RegistrationModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(registrationModels: List<RegistrationModel>)

    @Update
    suspend fun update(registrationModel: RegistrationModel)

    @Delete
    suspend fun delete(registrationModel: RegistrationModel)

    @Query("SELECT * FROM RegistrationModel")
    fun getRegistrationData(): RegistrationModel

    @Query("DELETE FROM RegistrationModel")
    fun clearRegistrationData()
}