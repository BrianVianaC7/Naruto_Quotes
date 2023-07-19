package com.example.mvvm_cases.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvm_cases.data.model.QuoteModel
import com.example.mvvm_cases.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "quote") val quote:String,
    @ColumnInfo(name= "author") val author:String,
    @ColumnInfo(name= "image") val image:String
)

fun Quote.toDatabase() = QuoteEntity(quote = quote, author = author, image = image)