package com.example.coviddata

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.example.coviddata.di.module.AppModule

class App : MultiDexApplication() {


    val Activity.app: App
        get() = application as App

    open val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}