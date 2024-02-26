package com.example.rickapi2ndex.data

import com.example.rickapi2ndex.model.Character

import com.example.rickapi2ndex.model.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface CartoonApiService {

    //get all characters
    @GET("character")
    suspend fun getAllCartoons() : Character

    //get a single character
    @GET("character/{id}")
    suspend fun getSingleCartoons(@Path("id") id: Int): Result
}