package com.example.mvvm_cases.domain

import com.example.mvvm_cases.data.QuoteRepository
import com.example.mvvm_cases.data.model.QuoteModel
import com.example.mvvm_cases.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDataBase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber : Int = (0..quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null
    }

}