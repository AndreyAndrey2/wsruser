package com.example.wsruserfood.data.network.api

import com.example.wsruserfood.data.models.remote.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface FoodApi {
    @GET("dishes/version")
    suspend fun getVersions() : Versions

    @GET("dishes")
    suspend fun getDishes(
        @Query("version") version: String
    ) : MutableList<DishResponse>

    @POST("auth/register")
    suspend fun postRegister(
        @Body request: RegisterRequest
    ) : Call<TokenResponse>

    @POST("auth/login")
    fun postAuth(
        @Body request: AuthRequest
    ) : Call<TokenResponse>
}