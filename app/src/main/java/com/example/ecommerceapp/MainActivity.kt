package com.example.ecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceapp.Screens.Home.HomeScreen
import com.example.ecommerceapp.Screens.cart.CartScreen
import com.example.ecommerceapp.Screens.categories.CategoryScreen
import com.example.ecommerceapp.Screens.navigation.Screens
import com.example.ecommerceapp.Screens.product.ProductDetailsScreen
import com.example.ecommerceapp.Screens.product.ProductScreen
import com.example.ecommerceapp.Screens.profile.LoginScreen
import com.example.ecommerceapp.Screens.profile.ProfileScreen
import com.example.ecommerceapp.Screens.profile.SignUpScreen
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController=navController , startDestination = Screens.Home.route){
                composable(Screens.Home.route){
                    HomeScreen(navController)}

                composable(Screens.Cart.route){
                    CartScreen(navController)}

                composable(Screens.Profile.route){

                    ProfileScreen(navController=navController , onSignOut = {})
                }

                composable(Screens.Categories.route) {
                    CategoryScreen(navController = navController)
                }
                composable(Screens.ProductDetails.route) {
                    val productId = it.arguments?.getString("productId")
                    if (productId != null) {
                        ProductDetailsScreen(productId = productId)
                    }
                }
                composable(Screens.ProductList.route) {
                    val categoryId = it.arguments?.getString("categoryId")
                    if (categoryId != null) {
                        ProductScreen(categoryId ,
                            navController = navController)
                    }
                }

                composable(Screens.SignUp.route) {
                    SignUpScreen(onNavigatToLogin = {
                        navController.navigate(Screens.Login.route)},
                        onSignUpSuccess = {navController.navigate(Screens.Home.route)})
                }

                composable(Screens.Login.route) {
                    LoginScreen(onLoginSuccess = {
                        navController.navigate(Screens.Home.route)},
                        onNavigateToSignUp = {navController.navigate(Screens.SignUp.route)})
                }
                composable(Screens.CategoryList.route) {
                    CategoryScreen(navController = navController)}

            }

        }
    }
}
