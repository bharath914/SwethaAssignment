package com.example.swethaassignment.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.example.swethaassignment.data.PagingSourceData
import com.example.swethaassignment.data.entity.Customer
import com.example.swethaassignment.data.entity.doesMatchesQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pagingSourceData: PagingSourceData,
) : ViewModel() {

    val pagingFlow = Pager(
        config = PagingConfig(10, prefetchDistance = 0),
        pagingSourceFactory = {
            pagingSourceData
        }
    ).flow


    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()


    val filteredItems =
        searchText
            // Optional: debounce to avoid filtering on every keystroke
            .flatMapLatest { text ->
                pagingFlow.map { pagingData ->
                    pagingData.filter { customer ->
                        customer.doesMatchesQuery(text)
                    }
                }
            }
            .cachedIn(
                viewModelScope,
//                SharingStarted.WhileSubscribed(5000),
//                PagingData.empty()
            )

    fun onSearchChange(text: String) {
        _searchText.update { text }
    }

}