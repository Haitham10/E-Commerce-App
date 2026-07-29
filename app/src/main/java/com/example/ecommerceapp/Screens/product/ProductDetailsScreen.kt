package com.example.ecommerceapp.Screens.product

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.rememberAsyncImagePainter
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.viewmodels.ProductViewModel

@Composable
fun ProductDetailsScreen(productId: String ,
                         productViewModel: ProductViewModel = hiltViewModel())
{

    LaunchedEffect(productId){ productViewModel.fetchProductDetails(productId) }

   val productState = productViewModel.product.collectAsState()
    val product = productState.value

    if (product==null){
        Text(text = "Product not found")
    }
    else{
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

            Image(painter = rememberAsyncImagePainter(model = product.imageUrl ,
               ),
                contentDescription = "${product.name} Image" ,
                contentScale = ContentScale.Crop ,
                modifier = Modifier.fillMaxWidth().height(300.dp)
                    .clip(RoundedCornerShape(12.dp)))

            Text(text = product.name ,
                style = MaterialTheme.typography.titleLarge ,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "$${product.price}",
                style = MaterialTheme.typography.titleMedium ,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "product description",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold)



        }

        IconButton(onClick = {} , modifier = Modifier.padding(16.dp)
            .background(MaterialTheme.colorScheme.primary ,
                shape = CircleShape
            )) {
            Icon(imageVector = Icons.Default.ShoppingCart ,
                contentDescription = "Add to cart" ,
                tint = Color.White)
        }
    }

}