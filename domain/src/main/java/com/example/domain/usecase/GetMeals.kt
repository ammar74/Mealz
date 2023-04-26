package com.example.domain.usecase

import com.example.domain.repo.MealsRepo

class GetMeals(private val mealsRepo :MealsRepo) {
    // operator fun دي بستخدمها لما يكون السبب ف انشاء ال كلاس دة هو اننا نستخدم ال الميثود دي
    // خليناها suspend عشان هنستخدم coroutines

    suspend operator fun invoke() = mealsRepo.getMealsFromServer()
}