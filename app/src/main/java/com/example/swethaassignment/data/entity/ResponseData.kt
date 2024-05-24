package com.example.swethaassignment.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class ResponseData(
    @SerialName("pageCount") val pageCount: Int,
    @SerialName("pageNo") val pageNo: Int,
    @SerialName("totalPages") val totalPages: Int
)