
package com.example.geradordejogosloto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnLoto: Button
    private lateinit var btnMega: Button
    private lateinit var btnQuina: Button
    private lateinit var btnDupla: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoto = findViewById(R.id.buttonLoto)

        btnLoto.setOnClickListener {
            //Navegar para proxima tela

            val i = Intent(this, lotofacilActivity::class.java)
            startActivity(i)


        }
        btnMega = findViewById(R.id.buttonMega)

        btnMega.setOnClickListener {
            //Navegar para proxima tela

            val i = Intent(this, MegaSenaActivity::class.java)
            startActivity(i)
        }
        btnQuina = findViewById(R.id.buttonQuina)

        btnQuina.setOnClickListener {
            //Navegar para proxima tela

            val i = Intent(this, QuinaActivity::class.java)
            startActivity(i)
        }
        btnDupla = findViewById(R.id.buttonDupla)

        btnDupla.setOnClickListener {
            //Navegar para proxima tela

            val i = Intent(this, DuplaActivity::class.java)
            startActivity(i)
        }
    }
}