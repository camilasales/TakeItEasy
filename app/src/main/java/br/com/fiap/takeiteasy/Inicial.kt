package br.com.fiap.takeiteasy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Inicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        val btnDesafio1: Button = findViewById(R.id.btn_desafio1);

        btnDesafio1.setOnClickListener(){
            openActivityMinhaSaude()
        }

    }

    fun openActivityMinhaSaude(){
        val intent = Intent(this, MinhaSaude::class.java);
        startActivity(intent);
    }
}