package com.example.swethaassignment.data

import com.example.swethaassignment.data.entity.CustomersData
import retrofit2.http.GET
import retrofit2.http.Query

val BASE_URL = "https://machintestapi.erpguru.in/api/CustomerDetails/"

interface CowsApi {
    @GET("GetCustomerDetails")
    suspend fun getCustomerData(
        @Query("pageno") pageNo: Int,
        @Query("pagesize") pageSize: Int,
        @Query("UnitId") unitId: Int,
    ): CustomersData
}