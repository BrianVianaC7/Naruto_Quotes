package com.example.mvvm_cases.data

import com.example.mvvm_cases.data.database.dao.QuoteDao
import com.example.mvvm_cases.data.database.entities.QuoteEntity
import com.example.mvvm_cases.data.model.QuoteModel
import com.example.mvvm_cases.data.network.QuoteService
import com.example.mvvm_cases.domain.model.Quote
import com.example.mvvm_cases.domain.model.toDomain
import javax.inject.Inject


class QuoteRepository @Inject constructor(
    private val api:QuoteService,
    private val quoteDao: QuoteDao
){

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response : List<QuoteModel> = api.getQuotes()
        return response.map { convert -> convert.toDomain() }
    }

    suspend fun getAllQuotesFromDataBase(): List<Quote> {
        val response :List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { convert -> convert.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}