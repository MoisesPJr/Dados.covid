package com.example.coviddata.di.module

import com.example.coviddata.service.CovidService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
open class CovidModule {

    val baseUrl = "https://covid19-brazil-api.vercel.app/api/report/"

    @Provides
    @Singleton
    @Named("countryRetrofit")
    fun providesRetrofitCovid(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    open fun providesCountryService(@Named("countryRetrofit") retrofit: Retrofit): CovidService =
        retrofit.create(CovidService::class.java)


}