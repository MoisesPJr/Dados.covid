package com.example.coviddata

import android.app.Application
import com.example.coviddata.di.module.AppModule
import com.example.coviddata.di.module.CountryModule
import com.example.coviddata.plugin.CountryViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        CountryModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)
    fun inject(application: Application)
    fun inject(viewModel: CountryViewModel)
    fun inject(activity: MainActivity)

}