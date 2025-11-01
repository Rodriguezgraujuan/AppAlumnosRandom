package com.example.appalumnosrandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var tvAlumno: TextView
    private lateinit var btnSiguiente: Button
    private lateinit var btnReiniciar: Button

    private val alumnosOriginal = listOf(
        "Ana", "Luis", "María", "Pedro", "Sofía",
        "Carlos", "Lucía", "Javier", "Paula", "Andrés"
    )

    private var alumnosDisponibles = alumnosOriginal.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvAlumno = findViewById(R.id.tvAlumno)
        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnReiniciar = findViewById(R.id.btnReiniciar)

        btnSiguiente.setOnClickListener { mostrarAlumnoRandom() }
        btnReiniciar.setOnClickListener { reiniciarLista() }
    }

    private fun mostrarAlumnoRandom() {
        if (alumnosDisponibles.isEmpty()) {
            Toast.makeText(this, "Ya salieron todos los alumnos", Toast.LENGTH_SHORT).show()
            return
        }

        val indice = Random.nextInt(alumnosDisponibles.size)
        val alumnoSeleccionado = alumnosDisponibles[indice]

        tvAlumno.text = alumnoSeleccionado
        alumnosDisponibles.removeAt(indice)
    }

    private fun reiniciarLista() {
        alumnosDisponibles = alumnosOriginal.toMutableList()
        tvAlumno.text = "Lista reiniciada"
        Toast.makeText(this, "Se reinició la lista", Toast.LENGTH_SHORT).show()
    }
}