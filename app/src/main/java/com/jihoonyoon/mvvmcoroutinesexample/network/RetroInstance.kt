package com.jihoonyoon.mvvmcoroutinesexample.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {
        private const val BaseUrl = "https://api.github.com/search/"

        fun getRetroInstance(): Retrofit{

            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}