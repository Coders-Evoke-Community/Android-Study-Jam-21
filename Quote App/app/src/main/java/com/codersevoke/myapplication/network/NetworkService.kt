package com.codersevoke.myapplication.network

import com.codersevoke.myapplication.model.QuoteResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    @GET(Endpoints.GET_QUOTE)
    fun getQuotes(): Call<QuoteResponse>
}