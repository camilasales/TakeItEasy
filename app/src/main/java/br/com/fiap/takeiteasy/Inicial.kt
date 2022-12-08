package br.com.fiap.takeiteasy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Inicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)



    }
    fun proximaTela(view: View) {
        val intent = Intent(this, MinhaSaude::class.java)
        startActivity(intent)
    }
}