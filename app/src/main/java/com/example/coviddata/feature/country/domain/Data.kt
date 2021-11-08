package com.example.coviddata.feature.country.domain

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*


data class Teste(
    val data: Data
)

@Parcelize
data class Data(
    @SerializedName("country")
    val country: String?,
    @SerializedName("cases")
    val cases: Long?,
    @SerializedName("confirmed")
    val confirmed: Int?,
    @SerializedName("deaths")
    val deaths: Int?,
    @SerializedName("recovered")
    val recovered: Long?,
    @SerializedName("updated_at")
    val updatedAt: Date?
): Parcelable