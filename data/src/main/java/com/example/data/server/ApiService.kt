package com.example.data.server

import com.example.domain.entity.CategoryResponse
import retrofit2.http.GET


interface ApiService {

    @GET("categories.php")
    suspend fun getMeals() : CategoryResponse
}