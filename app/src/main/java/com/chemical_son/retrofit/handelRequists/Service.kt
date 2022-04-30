package com.chemical_son.retrofit.handelRequists

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    companion object {
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}