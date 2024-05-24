package com.example.swethaassignment.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.swethaassignment.data.entity.Customer
import com.example.swethaassignment.data.repo.CowsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PagingSourceData @Inject constructor(
    private val repository: CowsRepository,
) : PagingSource<Int, Customer>() {
    override fun getRefreshKey(state: PagingState<Int, Customer>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Customer> {
        return withContext(Dispatchers.IO) {
            try {

                val pageNo = params.key ?: 1
                val pageSize = params.loadSize
                val unitId = 787
                val list = repository.getCustomersData(pageNo, pageSize, unitId)
                LoadResult.Page(
                    data = list,
                    prevKey = if (pageNo == 1) null else pageNo - 1,
                    nextKey = if (list.isEmpty()) null else pageNo + 1
                )

            } catch (e: Exception) {
                e.printStackTrace()
                LoadResult.Error(e)
            }
        }
    }
}