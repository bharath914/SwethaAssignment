package com.example.swethaassignment.data.repo

import com.example.swethaassignment.data.CowsApi
import com.example.swethaassignment.data.entity.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface CowsRepository {
    suspend fun getCustomersData(
        pageNo: Int,
        pageSize: Int,
        unitId: Int,
    ): List<Customer>

}

class CowsRepoImpl @Inject constructor(
    private val cowsApi: CowsApi,
) : CowsRepository {
    override suspend fun getCustomersData(
        pageNo: Int,
        pageSize: Int,
        unitId: Int,
    ): List<Customer> {
        try {
            val data = withContext(Dispatchers.IO) {
                cowsApi.getCustomerData(pageNo = pageNo, pageSize = pageSize, unitId = unitId)
            }
            return data.responseData
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyList()
        }
    }
}
