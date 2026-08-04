package com.example.ecommerceapp.room

import com.example.ecommerceapp.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val cartDao : CartDAO
) {
    val allCartItems : Flow<List<Product>> = cartDao.getAllCartItems()
}