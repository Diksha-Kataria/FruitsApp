package com.example.fruitapp.retrofit

import com.example.fruitapp.Fruit
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT

interface ApiInterface {
    @GET("api/fruit/all")
    fun getFruits() : Call<ArrayList<Fruit>>

    @PUT("/api/fruit")
    fun addFruit(@Body fruit: Fruit): Call<Fruit>
}