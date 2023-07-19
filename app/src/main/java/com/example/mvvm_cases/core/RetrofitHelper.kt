package com.example.mvvm_cases.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://narutoquotes-956b3-default-rtdb.firebaseio.com/Quotes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}