package com.example.mvvm_cases.domain.model

import com.example.mvvm_cases.data.database.entities.QuoteEntity
import com.example.mvvm_cases.data.model.QuoteModel
import com.google.gson.annotations.SerializedName

data class Quote(
    val quote:String,
    val author:String,
    val image:String
)

fun QuoteModel.toDomain() =Quote(quote, author, image)
fun QuoteEntity.toDomain() =Quote(quote, author, image)
