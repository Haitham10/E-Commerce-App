package com.example.ecommerceapp.Screens.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ecommerceapp.model.Product

@Composable
fun CartScreen(navController : NavController){
    val cartItems = listOf<Product>(Product(id = "1",
        name = "smart phone",
        price = 100.0,
        imageUrl = "https://www.shutterstock.com/image-illustration/mobile-phone-mockups-sample-home-600nw-2203389119.jpg"))

    Column(modifier = Modifier.fillMaxSize().padding(16.dp))
    {
        Text("My cart" ,
            style = MaterialTheme.typography.titleMedium ,
            modifier = Modifier.padding(bottom = 8.dp)
            )
            if (cartItems.isEmpty()){
                Column (modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center)
                {
                    Text(" Your cart is empty" ,
                        style = MaterialTheme.typography.bodyLarge)

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {}) {
                        Text("Continue Shopping")
                    }
                }
            }
        else{
                LazyColumn(modifier = Modifier.weight(1f))
                {
                    items(cartItems){
                        item -> CartItemCard(item) {}
                    }
                }
                Column(modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("Total:",
                            style = MaterialTheme.typography.titleMedium)

                        Text("$...",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold)

                    }

                    Button(onClick = {} , modifier = Modifier.fillMaxWidth()
                        .height(50.dp)) {
                        Text("Checkout")

                    }

                }
        }

    }
}