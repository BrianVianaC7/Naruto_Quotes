package com.example.mvvm_cases.domain

import com.example.mvvm_cases.data.QuoteRepository
import com.example.mvvm_cases.data.database.entities.toDatabase
import com.example.mvvm_cases.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository) {

    suspend operator fun invoke() :List<Quote> {

        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { convert -> convert.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDataBase()
        }
    }
}