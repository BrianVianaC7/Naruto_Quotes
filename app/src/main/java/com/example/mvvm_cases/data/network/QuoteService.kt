package com.example.mvvm_cases.data.network

import com.example.mvvm_cases.core.RetrofitHelper
import com.example.mvvm_cases.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val apiClient: QuoteApiClient) {

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getAllQuotes()
            response.body() ?: emptyList()
        }
    }

}