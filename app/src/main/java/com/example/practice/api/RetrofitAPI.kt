package com.example.practice.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {

    const val usersListURL = "https://jsonplaceholder.typicode.com/"

    fun getRetrofitApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(usersListURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun create(): API {
        return getRetrofitApi()
            .create(API::class.java)
    }
}

