package com.example.appsqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome:EditText = findViewById(R.id.edtNome)
        val edtEndereco:EditText = findViewById(R.id.edtEndereco)
        val edtBairro:EditText = findViewById(R.id.edtBairro)
        val edtCep:EditText = findViewById(R.id.edtCep)
        val edtObs:EditText = findViewById(R.id.edtObs)

        val btnCadastrar:Button = findViewById(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            val intent = Intent(this, RespostaActivity::class.java)
            intent.putExtra("nome",edtNome.text.toString())
            intent.putExtra("endereco",edtEndereco.text.toString())
            intent.putExtra("bairro",edtBairro.text.toString())
            intent.putExtra("cep",edtCep.text.toString())
            intent.putExtra("observacoes",edtObs.text.toString())
            startActivity(intent)
        }
    }
}