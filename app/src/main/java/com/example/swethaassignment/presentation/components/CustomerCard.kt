package com.example.swethaassignment.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.swethaassignment.R
import com.example.swethaassignment.data.entity.Customer

@Composable
fun CustomerCard(
    modifier: Modifier = Modifier,
    customer: Customer,
    isCow: Boolean,
) {
    Card(modifier) {
        Row(modifier) {
            AsyncImage(
                model = if (isCow) R.drawable.cow else R.drawable.buffalo,
                contentDescription = "Image",
                modifier = Modifier.size(90.dp)
            )

            Column {
                Text(text = customer.fName)
                Text(text = customer.mobileNo)
            }
        }
    }

}