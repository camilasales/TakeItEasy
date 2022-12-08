package br.com.fiap.takeiteasy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast

class MinhaSaude : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minha_saude)

        val layoutFruta: Button = findViewById(R.id.btn_beber)

        layoutFruta.setOnClickListener {
            val call = RetrofitFactoryAlimentos().retrofitServiceFruit().getAliments()

            call.enqueue(object : Callback<ALIMENTO> {
               override fun onResponse(call: Call<ALIMENTO>, response: Response<ALIMENTO>){
                   response.body()?.let {
                       Log.i("alimento", it.toString())
                       Toast.makeText(this@MinhaSaude, it.toString(), Toast.LENGTH_LONG).show()
                   }?: Toast.makeText(this@MinhaSaude, "CEP não localizado", Toast.LENGTH_LONG).show()
               }

                override fun onFailure(call: Call<ALIMENTO>, t: Throwable) {
                    Toast.makeText(this@MinhaSaude, "error", Toast.LENGTH_LONG).show()
                }
            })

        }

        //--  layoutFruta.setOnClickListener {
            //-- val call = RetrofitFactoryAlimentos().retrofitServiceFruit().getAliments();


            //--  call.enqueue(object : Callback<ALIMENTO> {
            //--    override fun onResponse(call: Call<ALIMENTO>, response: Response<ALIMENTO>) {
            //--        response.body()?.let {
            //--        Log.i("CEP", it.toString())
//--
            //--                    Toast.makeText(this@MinhaSaude, it.toString(), Toast.LENGTH_LONG).show()
//--
            //--                } ?: Toast.makeText(this@MinhaSaude, "CEP não localizado", Toast.LENGTH_LONG)
            //--        .show()
            //--}
//--
            //--            override fun onFailure(call: Call<ALIMENTO>, t: Throwable) {
            //--    TODO("Not yet implemented")
            //--}

            //-- });
        //-- }
    }
}