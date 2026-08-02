package com.example.ecommerceapp.room;

import androidx.room.Database;

import com.example.ecommerceapp.model.Product;

@Database(entities = [Product::class] , version = 1 , exportSchema = false)
abstract public class AppDateBase {
}
