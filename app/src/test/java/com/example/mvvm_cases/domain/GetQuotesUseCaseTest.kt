package com.example.mvvm_cases.domain

import com.example.mvvm_cases.data.QuoteRepository
import com.example.mvvm_cases.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class GetQuotesUseCaseTest{

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    //If you put the name of the function between of `` you can put spaces on the function
    @Test
    fun  `when the api doesnt return anything then get values from database`() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        //When
        getQuotesUseCase()

        //Then
        coVerify (exactly = 1) { quoteRepository.getAllQuotesFromDataBase() }
        coVerify (exactly = 0) { quoteRepository.clearQuotes() }
        coVerify (exactly = 0) { quoteRepository.insertQuotes(any()) }
    }

    //If you put the name of the function between of `` you can put spaces on the function
    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        //Given
        val myList = listOf(Quote("segundo test", "getQuotesUseCase","URL"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns myList

        //When
        val response = getQuotesUseCase()

        //Then
        coVerify (exactly = 1) { quoteRepository.clearQuotes() }
        coVerify (exactly = 1) { quoteRepository.insertQuotes(any()) }
        coVerify (exactly = 0) { quoteRepository.getAllQuotesFromDataBase() }
        assert(myList == response)
    }

}