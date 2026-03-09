package com.minasaur.campuscoffee

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

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

        val btn = findViewById<Button>(R.id.btnSubmit)

        val txtError = findViewById<TextView>(R.id.txtError)



        btn.setOnClickListener { v ->

            var valid = true
            var errorMessage = ""

            // Get name from EditText
            val nameForOrder = findViewById<EditText>(R.id.nameForOrder).text

            // Get selected type from radio
            val coffeeTypeId = findViewById<RadioGroup>(R.id.coffeeType).checkedRadioButtonId
            val coffeeType = findViewById<RadioButton>(coffeeTypeId)?.text

            // Get selected size from radio
            val coffeeSizeId = findViewById<RadioGroup>(R.id.coffeeSize).checkedRadioButtonId
            val coffeeSize = findViewById<RadioButton>(coffeeSizeId)?.text

            // Validate
            if (nameForOrder.isEmpty()) {
                errorMessage += "\nNo Name Submitted"
                valid = false
            }
            if (coffeeType == null) {
                errorMessage += "\nNo Coffee Type Selected"
                valid = false
            }
            if (coffeeSize == null) {
                errorMessage += "\nNo Size Selected"
                valid = false
            }

            if (!valid) {
                txtError.text = errorMessage
                return@setOnClickListener
            }

            val intent = Intent(this@MainActivity, ActivityTwo::class.java)

            // Add Extras
            intent.putExtra("Name", nameForOrder)
            intent.putExtra("CoffeeType", coffeeType)
            intent.putExtra("CoffeeSize", coffeeSize)

            startActivity(intent)
        }
    }
}