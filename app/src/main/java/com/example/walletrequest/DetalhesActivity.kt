package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val dados = intent.extras
        val name = dados?.getString("KEY_NAME")
        val number = dados?.getString("KEY_NUMBER")
        val vencimento = dados?.getString("KEY_VENCIMENTO")


        val tvCardName = findViewById<TextView>(R.id.tvCardNome)
        val tvCardNumber = findViewById<TextView>(R.id.tvCardNumber)
        val tvCardValidade = findViewById<TextView>(R.id.tvCardValidade)
        val btAvanca = findViewById<Button>(R.id.button3)

        tvCardName.text = name
        tvCardNumber.text = number
        tvCardValidade.text = vencimento

        btAvanca.setOnClickListener {
            val intentCard = Intent(this, ListaActivity::class.java)
            startActivity(intentCard)
        }




    }
}


