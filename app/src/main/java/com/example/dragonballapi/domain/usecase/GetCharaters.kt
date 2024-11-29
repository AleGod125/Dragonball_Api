package com.example.dragonballapi.domain.usecase

import com.example.dragonballapi.data.response.ModuleAPi

class GetCharaters {
    suspend fun getCharacters(page: Int, limit: Int) =
        ModuleAPi.api.getCharacters(page,limit)
}