package com.example.walletrequest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    val retroConf = Retrofit.Builder()
        .baseUrl("https://wallet-backend-theta.vercel.app/")
       .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: CardService = retroConf.create (CardService::class.java)

    companion object {

        fun getRetrofitInstance(path : String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
