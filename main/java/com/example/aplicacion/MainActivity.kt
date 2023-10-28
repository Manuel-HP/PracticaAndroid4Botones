package com.example.aplicacion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
private val url = "https://www.google.com/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Botón llamar
        val LlamadaButton = findViewById<Button>(R.id.button1)
        LlamadaButton.setOnClickListener {
            val intent = Intent(this,ActivityLlamada::class.java)
            startActivity(intent)
        }

        //Botón para salir a internet
        val botonNavegador = findViewById<Button>(R.id.button3)
        botonNavegador.setOnClickListener {
          val uri = Uri.parse(url)
            val intent2 =Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent2)
        }

        //Boton para usar el maps
        val botonMaps = findViewById<Button>(R.id.button4)
        botonMaps.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        //Botón alarma
        val botonAlarma = findViewById<Button>(R.id.button2)
        botonAlarma.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "MENSAJE")
                putExtra(AlarmClock.EXTRA_HOUR, 12)
                putExtra(AlarmClock.EXTRA_MINUTES, 20)
            }

                startActivity(intent)

        }

    }
}