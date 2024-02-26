package com.example.rickapi2ndex.data

import com.example.rickapi2ndex.model.Character

import com.example.rickapi2ndex.model.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface CartoonApiService {

    @GET("character")
    suspend fun getAllCartoons() : Character

    @GET("character/{id}")
    suspend fun getAllCharacters(@Path("id") id: Int) : Result
}