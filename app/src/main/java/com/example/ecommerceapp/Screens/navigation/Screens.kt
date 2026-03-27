package com.example.ecommerceapp.Screens.navigation

sealed class Screens(val route : String) {
    object Cart : Screens("Cart")
    object Categories : Screens("Categories")
    object Home : Screens("Home")
    object Profile : Screens("Profile")
    object ProductDetails : Screens("product_details/{productId}"){
        fun createRoute(productId : String) = "product_details/$productId"
    }
    object ProductList : Screens("product_list/{categoryId}"){
        fun createRoute(categoryId : String) = "product_list/$categoryId"
    }
    object CategoryList : Screens("category_list")
    object Login : Screens("Login")
    object SignUp : Screens("sign_up")


}