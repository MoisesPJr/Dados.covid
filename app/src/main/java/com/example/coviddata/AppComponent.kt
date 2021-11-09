package com.example.coviddata

import android.app.Application
import com.example.coviddata.di.module.AppModule
import com.example.coviddata.di.module.CovidModule
import com.example.coviddata.plugin.CountryViewModel
import com.example.coviddata.plugin.StateViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        CovidModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)
    fun inject(application: Application)
    fun inject(viewModel: CountryViewModel)
    fun inject(viewModel: StateViewModel)
    fun inject(activity: MainActivity)

}