package com.mikhail.effectivemobiletestquest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mikhail.effectivemobiletestquest.data.database.dao.RegistrationDao
import com.mikhail.effectivemobiletestquest.data.database.models.RegistrationModel

@Database(entities = [RegistrationModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun registrationDao(): RegistrationDao

    companion object {
        lateinit var INSTANCE: AppDatabase
            private set

        fun initDatabase(context: Context) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}