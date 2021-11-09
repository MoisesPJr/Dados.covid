package com.example.coviddata.feature.States.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*


@Parcelize
data class Estado(
    @SerializedName("uid")
    val uid: Int?,
    @SerializedName("uf")
    val uf: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("cases")
    val cases: Int?,
    @SerializedName("deaths")
    val deaths: Int?,
    @SerializedName("suspects")
    val suspect: Int?,
    @SerializedName("refuses")
    val refuses: Int?,
    @SerializedName("broadcast")
    val broadcast: Boolean?,
    @SerializedName("comments")
    val comments: String?,
    @SerializedName("datetime")
    val dateTime: Date?,
) : Parcelable