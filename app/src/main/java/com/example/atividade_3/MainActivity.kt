package com.example.atividade_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeEditText = findViewById<EditText>(R.id.editNome)
        val emailEditText = findViewById<EditText>(R.id.editEmail)
        val generoSpinner = findViewById<Spinner>(R.id.spinnerGenero)
        val faixaEtariaGroup = findViewById<RadioGroup>(R.id.radioGroupFaixaEtaria)
        val notificacoesCheckBox = findViewById<CheckBox>(R.id.checkNotificacoes)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        // Configurar Spinner
        val generos = arrayOf("Selecione o gênero:","Romance", "Fantasia", "Terror", "Ficção Científica", "Biografia", "HQ")
        generoSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, generos)

        btnCadastrar.setOnClickListener {
            val nome = nomeEditText.text.toString()
            val email = emailEditText.text.toString()
            val genero = generoSpinner.selectedItem.toString()
            val faixaEtariaId = faixaEtariaGroup.checkedRadioButtonId

            if (nome.isBlank() || email.isBlank() || faixaEtariaId == -1) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val faixaEtaria = findViewById<RadioButton>(faixaEtariaId).text.toString()
            val desejaNotificacoes = if (notificacoesCheckBox.isChecked) "Sim" else "Não"

            val intent = Intent(this, ResumoActivity::class.java).apply {
                putExtra("nome", nome)
                putExtra("email", email)
                putExtra("genero", genero)
                putExtra("faixaEtaria", faixaEtaria)
                putExtra("notificacoes", desejaNotificacoes)
            }

            startActivity(intent)
        }
    }
}