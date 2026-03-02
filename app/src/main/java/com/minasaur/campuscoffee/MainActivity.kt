package com.minasaur.campuscoffee

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onStart() {
        super.onStart()

        Log.d("LIFECYCLE", "onStart() was ran!")
    }


    override fun onDestroy() {
        super.onDestroy()

        Log.d("LIFECYCLE", "onDestroy() was ran!")
    }

    override fun onPause() {
        super.onPause()

        Log.d("LIFECYCLE", "onPause() was ran!")
    }

    override fun onResume() {
        super.onResume()

        Log.d("LIFECYCLE", "onResume() was ran!")
    }

    override fun onStop() {
        super.onStop()

        Log.d("LIFECYCLE", "onStop() was ran!")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LIFECYCLE", "onCreate() was ran!")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}