package com.example.movie_api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{
        lateinit var retrofit: Retrofit

        var BASE_URL="https://api.themoviedb.org/3/"

        fun getApiClient():Retrofit{
            retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            return retrofit
        }
    }
}