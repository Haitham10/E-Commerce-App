package com.example.ecommerceapp.room

import android.util.Log
import com.example.ecommerceapp.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val cartDao : CartDAO
) {
    val allCartItems : Flow<List<Product>> = cartDao.getAllCartItems()

    suspend fun addtoCart (product: Product){
      val existingItem = cartDao.getCartItemById(product.id)
        if (existingItem!=null){
            Log.v("TAGY" ,"Product is already added")
            cartDao.updateCartItem(product)
        }
        else{
            cartDao.insertCartItem(product)
            Log.v("TAGY" ,"Product is  added")
        }
    }
    suspend fun removeCartItem(product: Product){
        cartDao.deleteCartItem(product)
        Log.v("TAGY" ,"Product removed")


    }

    suspend fun clearCart(){
        cartDao.clearCart()
    }



}