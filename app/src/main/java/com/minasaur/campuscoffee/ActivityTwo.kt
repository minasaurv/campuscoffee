package com.minasaur.campuscoffee

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_two)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get submitted data and build success message
        findViewById<TextView>(R.id.txtSuccess).text = buildString {
            append("Name: ${intent.getStringExtra("Name")}\n")
            append("CoffeeType: ${intent.getStringExtra("CoffeeType")}\n")
            append("CoffeeSize: ${intent.getStringExtra("CoffeeSize")}")
        }

        // Back button
        findViewById<Button>(R.id.btnBack).setOnClickListener { v ->
            finish()
        }
    }
}