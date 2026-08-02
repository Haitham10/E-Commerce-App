package com.example.ecommerceapp.Screens.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerceapp.Screens.navigation.Screens
import com.example.ecommerceapp.viewmodels.CategoryViewModel
import com.example.ecommerceapp.viewmodels.ProductViewModel
import org.tensorflow.lite.support.label.Category

@Composable
fun HomeScreen(navController : NavController ,
               productViewModel: ProductViewModel = hiltViewModel(),
               categoryViewModel: CategoryViewModel = hiltViewModel(),

){
    Scaffold (topBar = { MyTopAppBar() },
        bottomBar = { BottomNavigationBar() })
    {
        paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().
            padding(paddingValues)
        ) {
            val searchQuery = remember { mutableStateOf("") }
            val focusManager = LocalFocusManager.current

            SearchBar(query = searchQuery.value,
                onQueryChange = { searchQuery.value=it},
                onSearch = {},
                modifier = Modifier.fillMaxWidth().padding(16.dp)
                )
            val categoriesState = categoryViewModel.categories.collectAsState()
            val categories = categoriesState.value

            val selectedCategory = remember { mutableStateOf(0) }

            SectionTitle("Categories" ,"See all") {
                navController.navigate(Screens.CategoryList.route)
            }
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp))
            {
                items(categories.size) {
                        category ->
                    CategoryChip(icon = categories[category].iconUrl,
                        text = categories[category].name,
                        isSelected = selectedCategory.value == category,
                        onClick = {
                            selectedCategory.value = categories[category].id
                            navController.navigate(
                                Screens.ProductList.createRoute
                                    (selectedCategory.value.toString()))
                        }
                    )

                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Featured" ,"See all") {
                navController.navigate(Screens.CategoryList.route)
            }


            Spacer(modifier = Modifier.height(16.dp))

            productViewModel.getAllProductsInFirestore()

            val productListState = productViewModel.allProducts.collectAsState()
            val allProductFound = productListState.value

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)

            ) {
                items(allProductFound){
                    product -> FeaturedProductCard(product = product) {
                        navController.navigate(
                            Screens.ProductDetails.createRoute(product.id)
                        )

                }
                }
            }




        }

        }


    }
