package com.example.mvvm_cases.di

import android.content.Context
import androidx.room.Room
import com.example.mvvm_cases.data.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUOTE_DATABASE_NAME = "quote_database"

    @Singleton
    @Provides
    fun provideRoom(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,QuoteDatabase::class.java, QUOTE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(database: QuoteDatabase) = database.getQuoteDao()
}