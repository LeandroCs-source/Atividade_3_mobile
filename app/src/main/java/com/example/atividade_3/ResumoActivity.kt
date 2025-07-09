package com.example.atividade_3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo)

        val nome = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")
        val genero = intent.getStringExtra("genero")
        val faixaEtaria = intent.getStringExtra("faixaEtaria")
        val notificacoes = intent.getStringExtra("notificacoes")

        val textResumo = findViewById<TextView>(R.id.textResumo)

        val resumo = """
            
            
            Cadastro Realizado
            
            Nome: $nome
            E-mail: $email
            Gênero Literário Preferido: $genero
            Faixa Etária: $faixaEtaria
            Deseja receber notificações? $notificacoes
        """.trimIndent()

        textResumo.text = resumo
    }
}