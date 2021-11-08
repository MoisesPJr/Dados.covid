package com.example.coviddata

import androidx.multidex.MultiDexApplication
import com.example.coviddata.di.module.AppModule

class App : MultiDexApplication() {


    open val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}