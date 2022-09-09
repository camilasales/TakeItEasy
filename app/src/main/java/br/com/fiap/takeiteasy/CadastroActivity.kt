package br.com.fiap.takeiteasy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val pesquisaCEP: EditText = findViewById(R.id.input_cep)
        val cep: EditText = findViewById(R.id.input_cep)
        //-- val progress_bar: ProgressBar = findViewById(R.id.progress_bar)
        val logradouro: EditText = findViewById(R.id.input_logradouro)
        val bairro: EditText = findViewById(R.id.inpu_bairro)

        //-- Ao clicar no botão número 1
        //-- Será pesquisado o logradouro com o número do CEP
        pesquisaCEP.setOnClickListener {

            //-- progress_bar.visibility = View.VISIBLE

            val call = RetrofitFactory().retrofitService().getCEP(cep.text.toString())

            call.enqueue(object : Callback<CEP> {

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                    response.body()?.let {
                        Log.i("CEP", it.toString())
                        Toast.makeText(this@CadastroActivity, it.toString(), Toast.LENGTH_LONG).show()
                        //--  progress_bar.visibility = View.INVISIBLE
                    } ?: Toast.makeText(this@CadastroActivity, "CEP não localizado", Toast.LENGTH_LONG)
                        .show()

                }

                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                    //--  progress_bar.visibility = View.INVISIBLE
                }
            })
        }

        //-- Ao clicar no botão número 2
        //-- Será pesquisado o logradouro com os dados:
        //-- RUA, CIDADE e ENDEREÇO

    }
}
