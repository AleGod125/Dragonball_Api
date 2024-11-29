package com.example.dragonballapi.domain.model

data class CharatesModel(
    val id : Int,
    val name : String,
    val ki: String,
    val maxKi: String,
    val race : String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation : String,
    val deletedAt: String?
)

data class ApiResponseModel(
    val items: List<CharatesModel>
)
