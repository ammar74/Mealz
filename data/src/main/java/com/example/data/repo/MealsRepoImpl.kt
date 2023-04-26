package com.example.data.repo

import com.example.data.server.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService : ApiService): MealsRepo {
    override suspend fun getMealsFromServer(): CategoryResponse = apiService.getMeals()
}