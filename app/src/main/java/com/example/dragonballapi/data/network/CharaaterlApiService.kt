package com.example.dragonballapi.data.network

import com.example.dragonballapi.domain.model.ApiResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CharaaterlApiService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): ApiResponseModel
}