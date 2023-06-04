package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openCard = findViewById<Button>(R.id.btCadastrarCartao)
        openCard.setOnClickListener {

            val intentCard = Intent(this, CadastroActivity::class.java)
            startActivity(intentCard)
    }
        val listaCard = findViewById<Button>(R.id.btMeusCartoes)
        listaCard.setOnClickListener {
            val intentCard = Intent(this, ListaActivity::class.java)
            startActivity(intentCard)
        }


}
}