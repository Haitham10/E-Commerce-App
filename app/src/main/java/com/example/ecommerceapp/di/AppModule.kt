package com.example.ecommerceapp.di

import android.content.Context
import com.example.ecommerceapp.room.AppDataBase
import com.example.ecommerceapp.room.CartDAO
import com.example.ecommerceapp.room.CartRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext : Context) :
    AppDataBase{
        return AppDataBase.getDatabase(appContext)

    }
    @Provides
    fun provideCartDea(appDataBase: AppDataBase): CartDAO{
       return appDataBase.cartDao()
    }
    @Provides
    fun provideCartRepository(cartDAO: CartDAO): CartRepository{
        return CartRepository(cartDAO)
    }
}
