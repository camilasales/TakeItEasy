package br.com.fiap.takeiteasy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnlogin: Button = findViewById(R.id.btn_login);
        val textCadastrar: TextView = findViewById(R.id.text_cadastrar);

        btnlogin.setOnClickListener(){
            openActivityInicial();
        }

        textCadastrar.setOnClickListener(){
            openActivityCadastro();
        }
    }

    fun openActivityInicial(){
        val intent = Intent(this, MinhaSaude::class.java);
        startActivity(intent);
    }

    fun openActivityCadastro(){
        val intent = Intent(this, CadastroActivity::class.java);
        startActivity(intent);
    }
}