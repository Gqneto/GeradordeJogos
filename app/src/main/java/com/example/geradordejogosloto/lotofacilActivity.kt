
package com.example.geradordejogosloto

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

private lateinit var prefs: SharedPreferences

class lotofacilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotofacil)

        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        prefs = getSharedPreferences("db", Context.MODE_PRIVATE)
        val result = prefs.getString("result",null)
        if ( result != null){
            txtResult.text ="Ultima aposta : $result"
        }
        btnGenerate.setOnClickListener {

            val text = editText.text.toString()
            numberGenerator(text, txtResult)


        }


    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        if (text.isEmpty()) {
            Toast.makeText(this, "Informe um número entre 15 a 18", Toast.LENGTH_SHORT).show()
            return
        }
        val qtd = text.toInt()

        if (qtd < 15 || qtd > 18) {
            Toast.makeText(this, "Informe um número entre 15 a 18", Toast.LENGTH_SHORT).show()
            return
        }


        val numbers = mutableSetOf<Int>()
        val random = Random()


        while (true) {
            val number = random.nextInt(25)
            numbers.add(number + 1)

            if (numbers.size == qtd) {
                break
            }
        }
        txtResult.text = numbers.joinToString("-")

        var result = numbers.sortedBy {it}
        txtResult.text = result.joinToString(" - ")


        val editor = prefs.edit()
        editor.putString("result", txtResult.text.toString())
        editor.apply()
    }
}