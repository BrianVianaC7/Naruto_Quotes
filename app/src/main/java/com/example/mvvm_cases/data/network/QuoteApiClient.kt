package com.example.mvvm_cases.data.network

import com.example.mvvm_cases.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET(".json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}