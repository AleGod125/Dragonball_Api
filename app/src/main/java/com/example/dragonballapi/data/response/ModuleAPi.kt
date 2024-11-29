package com.example.dragonballapi.data.response

import com.example.dragonballapi.data.network.CharaaterlApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ModuleAPi {
val api : CharaaterlApiService by lazy {
    Retrofit.Builder()
        .baseUrl("https://dragonball-api.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(CharaaterlApiService::class.java)
    }
}