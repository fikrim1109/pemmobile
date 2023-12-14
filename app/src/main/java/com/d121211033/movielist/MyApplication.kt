package com.d121211033.movielist

import android.app.Application
import com.d121211033.movielist.data.AppContainer
import com.d121211033.movielist.data.DefaultAppContainer

class MyApplication : Application() {
    lateinit var container: AppContainer
        private set // Make the setter private to prevent external modifications

    override fun onCreate() {
        super.onCreate()
        initializeAppContainer()
    }

    private fun initializeAppContainer() {
        container = DefaultAppContainer()
    }
}
