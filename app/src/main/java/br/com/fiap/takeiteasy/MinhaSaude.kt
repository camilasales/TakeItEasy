package br.com.fiap.takeiteasy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MinhaSaude : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minha_saude)

        val layoutFruta: LinearLayout = findViewById(R.id.layout_fruta)

        layoutFruta.setOnClickListener {
            val call = RetrofitFactory().retrofitServicFruit().getAliments();


            call.enqueue(object : Callback<ALIMENTO> {
                override fun onResponse(call: Call<ALIMENTO>, response: Response<ALIMENTO>) {
                    response.body()?.let {
                        Log.i("CEP", it.toString())

                        Toast.makeText(this@MinhaSaude, it.toString(), Toast.LENGTH_LONG).show()

                    } ?: Toast.makeText(this@MinhaSaude, "CEP não localizado", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onFailure(call: Call<ALIMENTO>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            });
        }
    }
}