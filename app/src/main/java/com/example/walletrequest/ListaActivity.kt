package com.example.walletrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)





    }
    fun getCard() {
        val retrofitClient = RetrofitConfig
            .getRetrofitInstance("https://wallet-backend-theta.vercel.app/")

        val endpoint = retrofitClient.create(CardService::class.java)
        val service = endpoint.findAll()


        service.enqueue(object : Callback<List<Card>> {
            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                response.body()?.forEach {

                }
            }
            })



    }
fun findCard(listaDeCartoes:List<Card>){
    val recycler = findViewById<RecyclerView>(R.id.rvMeusCartoes)
    recycler.adapter = DroidVersionAdapter(listaDeCartoes)
}
    }



