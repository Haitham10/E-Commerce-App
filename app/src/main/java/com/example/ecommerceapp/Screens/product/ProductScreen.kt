package com.example.ecommerceapp.Screens.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ecommerceapp.model.Product

@Composable
fun ProductScreen(categoryId : String ,
                  navController : NavController){
    val products = listOf(Product(id = "1",
        name = "smart phone",
        price = 100.0,
        imageUrl = "https://www.shutterstock.com/image-illustration/mobile-phone-mockups-sample-home-600nw-2203389119.jpg"
    ),
        Product(id = "2",
            name = "Laptop",
            price = 300.0,
            imageUrl = "https://asani.co.id/wp-content/uploads/2023/08/ezgif.com-resize-8-1.jpg")
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Category ID : $categoryId" ,
            style = MaterialTheme.typography.titleLarge ,
            modifier = Modifier.padding(16.dp))
        if (products.isEmpty()){
            Text("No products found",
                modifier = Modifier.padding(12.dp))
        }
        else{
            LazyColumn(modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)) {
                items(products){
                    product -> ProductItem(product = product,
                        onClick = {navController.navigate("product_details/${product.id}")},
                        onAddToCart = {})
                }
            }

        }



    }

}