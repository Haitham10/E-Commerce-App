package com.example.ecommerceapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecommerceapp.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cartDao(): CartDAO

    companion object{

        @Volatile
        private var INSTANCE : AppDataBase? = null

        fun getDatabase(context : Context) : AppDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "cart_database"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }
    }


