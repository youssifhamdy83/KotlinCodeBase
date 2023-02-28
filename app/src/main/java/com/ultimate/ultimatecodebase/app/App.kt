package com.ultimate.ultimatecodebase.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp


/**
 * Created by Youssif Hamdy on 1/28/2023.
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        App.appContext = applicationContext
    }

    companion object {

        lateinit var appContext: Context

    }

}