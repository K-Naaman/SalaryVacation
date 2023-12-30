package com.example.humanresource

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openButton = findViewById<Button>(R.id.btnSalary)
        openButton.setOnClickListener {
            val intent = Intent(this,SalaryCalculator::class.java)
            startActivity(intent)
        }

        val openButton2 = findViewById<Button>(R.id.btnVacationCounter)
        openButton2.setOnClickListener {
            val intent2 = Intent(this,VacationCounter::class.java)
            startActivity(intent2)
        }


        val greetingTextView = findViewById<TextView>(R.id.greeting_text_view)
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        val greetingMessage = when (currentHour) {
            in 4..11 -> "Good morning"
            in 12..16 -> "Good afternoon"
            in 17..24 -> "Good evening"
            else -> "Hello, whats keeping you this late"
        }

        greetingTextView.text =" $greetingMessage"

    }
}