package com.example.swethaassignment.data.entity


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Customer(
    @SerialName("customerId") val customerId: Int,
    @SerialName("fName") val fName: String,
    @SerialName("isBuffalo") val isBuffalo: Int,
    @SerialName("isCow") val isCow: Int,
    @SerialName("lName") val lName: String,
    @SerialName("mName") val mName: String?,
    @SerialName("mobileNo") val mobileNo: String,
    @SerialName("rfName") val rfName: String?,
    @SerialName("rlName") val rlName: String?,
    @SerialName("rmName") val rmName: String?,
)

fun Customer.doesMatchesQuery(query: String): Boolean {
    val combinations = listOf(
        fName,
        lName,
    )
    return combinations.any {
        it.contains(query, true)
    }
}