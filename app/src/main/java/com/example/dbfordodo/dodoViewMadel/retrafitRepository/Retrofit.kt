package com.example.dbfordodo.dodoViewMadel.retrafitRepository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit   {
    private val interceptor = HttpLoggingInterceptor()
    init {

    interceptor.level= HttpLoggingInterceptor.Level.BODY
    }

   private val client= OkHttpClient.Builder().addInterceptor(interceptor).build()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.255.35:8080/").client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}