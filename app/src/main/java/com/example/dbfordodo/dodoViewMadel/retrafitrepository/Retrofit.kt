package com.example.dbfordodo.dodoViewMadel.retrafitrepository

import com.example.dbfordodo.dodoViewMadel.DodoViewMadel
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
        .baseUrl("http://10.0.2.2:8080/").client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}