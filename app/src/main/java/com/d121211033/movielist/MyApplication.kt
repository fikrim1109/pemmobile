package com.d121211033.movielist

import android.app.Application
import com.d121211033.movielist.data.AppContainer
import com.d121211033.movielist.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}