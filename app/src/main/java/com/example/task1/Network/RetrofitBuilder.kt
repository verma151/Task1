package com.example.task1.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit:Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BaseUrl.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:ApiServices by lazy{
        retrofit.create(ApiServices::class.java)
    }
}