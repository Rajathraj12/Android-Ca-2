package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.ui.theme.AppTheme

class Ecommerce : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                ECommerceApp()
                }
            }
        }
    }


@Composable
fun ECommerceApp() {
    var quantity by remember { mutableStateOf(0f) }
    var itemName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {

        Text(text = "E Commerce App")

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Quantity: ${quantity.toInt()}")

        Slider(
            value = quantity,
            onValueChange = { quantity = it },
            valueRange = 0f..10f
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (quantity > 0) {
            Text(text = "Item: $itemName")
            Text(text = "Quantity: ${quantity.toInt()}")
        } else {
            Text(text = "Quantity must be greater than zero")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    AppTheme {
        ECommerceApp()

    }
}