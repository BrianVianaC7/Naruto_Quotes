package com.example.mvvm_cases.domain

import com.example.mvvm_cases.data.QuoteRepository
import com.example.mvvm_cases.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class GetRandomQuoteUseCaseTest{
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }
    //If you put the name of the function between of `` you can put spaces on the function
    @Test
    fun  `when database is empty the return null`() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromDataBase() } returns emptyList()

        //When
        val response = getRandomQuoteUseCase()

        //Then
        assert(response == null)
    }

    //If you put the name of the function between of `` you can put spaces on the function
    @Test
    fun  `when database is not empty then return quote`() = runBlocking {
        //Given
        val quoteList = listOf(Quote("segundo test", "getRandomQuoteUseCase","URL"))
        coEvery { quoteRepository.getAllQuotesFromDataBase() } returns quoteList

        //When
        val response = getRandomQuoteUseCase()

        //Then
        assert(response == quoteList.first())
    }

}