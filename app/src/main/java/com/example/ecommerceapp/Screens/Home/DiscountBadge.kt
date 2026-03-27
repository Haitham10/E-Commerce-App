package com.example.ecommerceapp.Screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DiscountBadge(discountPercentage: Int ,
                  modifier: Modifier= Modifier)
{
    Box(modifier=modifier.clip(RoundedCornerShape(4.dp))
        .background(Color(0XFFE91e63))
    )
    {
        Text("$discountPercentage% OFF",
            color = Color.White ,
            fontWeight = FontWeight.Bold ,
            modifier= Modifier.padding(horizontal = 8.dp , vertical = 4.dp)
            )
    }
}