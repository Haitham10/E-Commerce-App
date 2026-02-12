package com.example.ecommerceapp.Screens.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.model.Category

@Composable
fun HomeScreen(){
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
            val categories : List<Category> = listOf(
                Category(
                    id = 1 , name = "Electronics" , iconUrl = "https://cdn-icons-png.flaticon.com/512/1555/1555401.png"),
                Category(
                    id = 2 , name = "Clothing" , iconUrl = "https://cdn-icons-png.flaticon.com/512/2230/2230695.png")
            )

            val selectedCategory = remember { mutableStateOf(0) }

            SectionTitle("Categories" ,"See all") { }
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp))
            {
                items(categories.size) {
                        category ->
                    CategoryChip(icon = categories[category].iconUrl,
                        text = categories[category].name,
                        isSelected = selectedCategory.value == category,
                        onClick = {
                            selectedCategory.value = category
                        }
                    )

                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Featured" ,"See all") { }






            Spacer(modifier = Modifier.height(16.dp))




        }

        }


    }
