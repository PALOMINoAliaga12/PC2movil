package com.palomino.luis.usolayoutsv4

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio01Activity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var btnMostrar: Button
    private lateinit var btnOcultar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        imageView = findViewById(R.id.imageView)
        btnMostrar = findViewById(R.id.btnMostrar)
        btnOcultar = findViewById(R.id.btnOcultar)

        btnMostrar.setOnClickListener {
            imageView.visibility = ImageView.VISIBLE
        }

        btnOcultar.setOnClickListener {
            imageView.visibility = ImageView.GONE
        }
    }
}
