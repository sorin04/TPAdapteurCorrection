package com.michael.retrofitcall.retrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Api_Retrofit {
    private const val BASE_URL: String = "https://run.mocky.io/v3/"

    val api : Interface_Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()

}
