package com.mikhail.effectivemobiletestquest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mikhail.effectivemobiletestquest.data.database.dao.ProductsDao
import com.mikhail.effectivemobiletestquest.data.database.dao.RegistrationDao
import com.mikhail.effectivemobiletestquest.data.database.models.ProductModel
import com.mikhail.effectivemobiletestquest.data.database.models.RegistrationModel

@TypeConverters(ProductInfoConverter::class, StringConverter::class)
@Database(entities = [RegistrationModel::class, ProductModel::class], version = 4, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun registrationDao(): RegistrationDao
    abstract fun productsDao(): ProductsDao

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