package com.mikhail.effectivemobiletestquest.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RegistrationModel")
data class RegistrationModel(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "surname")
    val surname: String,
    @PrimaryKey
    @ColumnInfo(name = "phoneNumber")
    val phoneNumber: String
) {
    companion object {
        val default = RegistrationModel(
            name = "",
            surname = "",
            phoneNumber = ""
        )
    }
}