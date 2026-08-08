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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.viewmodels.CartViewModel
import com.example.ecommerceapp.viewmodels.ProductViewModel

@Composable
fun ProductScreen(categoryId : String ,
                  navController : NavController ,
                  productViewModel: ProductViewModel = hiltViewModel(),
                  cartViewModel: CartViewModel = hiltViewModel()){

    LaunchedEffect(categoryId){
        productViewModel.fetchProducts(categoryId)
    }

   LaunchedEffect(categoryId) {
       productViewModel.fetchProducts(categoryId)
   }

    val productsState = productViewModel.products.collectAsState()
    val products = productsState.value

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
                        onAddToCart = {
                            cartViewModel.addToCart(product)
                        })
                }
            }

        }



    }

}