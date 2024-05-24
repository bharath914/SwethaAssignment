package com.example.swethaassignment.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.swethaassignment.presentation.components.CustomerCard

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<HomeViewModel>()
    Content(
        viewModel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(
    homeViewModel: HomeViewModel,
) {
    val pagingList = homeViewModel.pagingFlow.collectAsLazyPagingItems()


    val modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBox(homeViewModel = homeViewModel)
        LazyColumn {
            items(pagingList.itemSnapshotList) { cus ->
                cus?.let {
                    val isCow = it.isCow == 1
                    CustomerCard(modifier, customer = it, isCow)
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBox(
    homeViewModel: HomeViewModel,
) {
    val isActive = remember {
        mutableStateOf(false)
    }
    val modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    val searchText by homeViewModel.searchText.collectAsStateWithLifecycle()
    SearchBar(
        query = searchText,
        onQueryChange = homeViewModel::onSearchChange,
        onSearch = {},
        active = isActive.value,
        onActiveChange = {
            isActive.value = !isActive.value
        },
        placeholder = {
            Text(text = "Search here")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "")
        },
        trailingIcon = {
            if (isActive.value) {
                IconButton(onClick = { isActive.value = !isActive.value }) {
                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                }
            }
        }

    ) {

        val filteredItems = homeViewModel.filteredItems.collectAsLazyPagingItems()
        LazyColumn {
            items(filteredItems.itemSnapshotList) {

                it?.let {
                    val isCow = it.isCow == 1
                    CustomerCard(modifier, customer = it, isCow)

                }
            }
        }
    }
}