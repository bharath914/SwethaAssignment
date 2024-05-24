package com.example.swethaassignment.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class CustomersData(
    @SerialName("responseData") val responseData: List<Customer>,
    @SerialName("responseData1") val responseData1: ResponseData,
    @SerialName("statusCode") val statusCode: String,
    @SerialName("statusMessage") val statusMessage: String
)