package com.example.walletrequest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.UUID

class CadastroActivity : AppCompatActivity() {
    private  lateinit var configuracao: RetrofitConfig
    private lateinit var  servico: CardService

    companion object {
        const val KEY_NAME = "KEY_NAME"
        const val KEY_NUMBER = "KEY_NUMBER"
        const val KEY_VENCIMENTO = "KEY_VENCIMENTO"
        const val KEY_CODE = "KEY_CODE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        configuracao = RetrofitConfig()
        servico = configuracao.service

        val edName = findViewById<EditText>(R.id.edName)
        val edNumber = findViewById<EditText>(R.id.edNumber)
        val edVencimento = findViewById<EditText>(R.id.edVencimento)
        val edCode = findViewById<EditText>(R.id.edCode)

        val btAvancar = findViewById<Button>(R.id.btAvancar)
        btAvancar.setOnClickListener {
            val id: String = UUID.randomUUID().toString()
            val type = "BLACK"
            val name = edName.text
            val number = edNumber.text
            val vencimento = edVencimento.text
            val code = edCode.text

            val newCard = Card (
                id = id,
                name = name.toString(),
                cvv = code.toString(),
                number = number.toString(),
                expirationDate = vencimento.toString(),
                cardType = type
            )
            executarRequest(newCard)


            val intentCard = Intent(this@CadastroActivity, DetalhesActivity::class.java)
            intentCard.putExtra(KEY_NAME, name)
            intentCard.putExtra(KEY_CODE, code)
            intentCard.putExtra(KEY_NUMBER, number)
            intentCard.putExtra(KEY_VENCIMENTO, vencimento)
            startActivity(intentCard)


        }



    }
    private fun executarRequest(newCard: Card) {
        servico.createCard(newCard).enqueue(object : Callback<Card> {
            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                Toast.makeText(this@CadastroActivity, "Sucesso! Dados cadastrados com sucesso!", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Card>, t: Throwable) {
                Log.e("FATAL", t.message.orEmpty())
                Toast.makeText(this@CadastroActivity, "Erro! Falha de comunicação!", Toast.LENGTH_LONG).show()
            }
})
    }

}