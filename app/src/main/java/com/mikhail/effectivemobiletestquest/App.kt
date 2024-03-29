package com.mikhail.effectivemobiletestquest

import android.app.Application
import com.mikhail.effectivemobiletestquest.data.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object {
        private lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppDatabase.initDatabase(this)
    }
}