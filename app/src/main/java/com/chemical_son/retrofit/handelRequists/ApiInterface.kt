package com.chemical_son.retrofit.handelRequists

import com.chemical_son.retrofit.dataModel.TopHeadlinesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<TopHeadlinesResponse>
}