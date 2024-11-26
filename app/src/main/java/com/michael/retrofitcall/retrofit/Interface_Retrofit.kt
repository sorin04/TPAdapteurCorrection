package com.michael.retrofitcall.retrofit

import com.michael.retrofitcall.pojo.EtuItem
import retrofit2.Call
import retrofit2.http.GET

interface Interface_Retrofit {
    @GET("a854dea6-b046-435a-969b-b5dbc6a1e456")
    fun getEtudiant(): Call<EtuItem>

    @GET("01f7fecc-a8f1-4c30-9f56-e95f4c47183c")
    fun getAllEtudiants(): Call<ArrayList<EtuItem>>


}

//un seul etudiant generique
    //https://run.mocky.io/v3/a854dea6-b046-435a-969b-b5dbc6a1e456

//tous les etudiants 2BTS SN-IR 2024
    //https://run.mocky.io/v3/01f7fecc-a8f1-4c30-9f56-e95f4c47183c