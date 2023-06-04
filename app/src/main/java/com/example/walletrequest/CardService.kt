package com.example.walletrequest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CardService {
//Métodos que podem ser operados na API

    @GET("cards")
    fun findAll(): Call<List<Card>>

    @GET("cards/{cardId}")
    fun findById(@Path("id") cardId: String): Call<Card>

    @POST("cards")
    fun createCard(@Body card: Card): Call<Card>

    @PUT("cards/{id}")
    fun updateCard(@Path("id") cardId: String, @Body card: Card) : Call<Card>

    @DELETE("cards/{cardId}")
    fun deleteCard(@Path("id") cardId: String): Call<Card>

    @DELETE ("cards")
    fun deleteAll(): Call<Any>




}