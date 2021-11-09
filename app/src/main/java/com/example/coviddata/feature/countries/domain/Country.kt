package com.example.coviddata.feature.countries.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class Country(
    @SerializedName("country")
    val country: String?,
    @SerializedName("cases")
    val cases: Int?,
    @SerializedName("confirmed")
    val confirmed: Int?,
    @SerializedName("deaths")
    val deaths: Int?,
    @SerializedName("recovered")
    val recovered: Int?,
    @SerializedName("updated_at")
    val updatedAt: Date?
): Parcelable