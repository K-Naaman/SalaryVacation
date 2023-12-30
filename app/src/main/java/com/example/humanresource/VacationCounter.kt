package com.example.humanresource

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class VacationCounter : AppCompatActivity() {
    private lateinit var fromDateButton: Button
    private lateinit var toDateButton: Button
    private lateinit var submitButton: Button
    private lateinit var leaveDaysText: TextView
    private lateinit var fromDate: Date
    private lateinit var toDate: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vacation_counter)

        fromDateButton = findViewById(R.id.from_date_button)
        toDateButton = findViewById(R.id.to_date_button)
        submitButton = findViewById(R.id.submit_button)
        leaveDaysText = findViewById(R.id.leave_days_text)
        fromDateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    fromDate = Calendar.getInstance().apply {
                        set(year, monthOfYear, dayOfMonth)
                    }.time
                    fromDateButton.text = SimpleDateFormat(
                        "dd MMM yyyy",
                        Locale.US
                    ).format(fromDate)
                }, year, month, dayOfMonth
            )
            datePickerDialog.show()
        }
        toDateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    toDate = Calendar.getInstance().apply {
                        set(year, monthOfYear, dayOfMonth)
                    }.time
                    toDateButton.text = SimpleDateFormat(
                        "dd MMM yyyy",
                        Locale.US
                    ).format(toDate)
                }, year, month, dayOfMonth
            )
            datePickerDialog.show()
        }
        submitButton.setOnClickListener {
            if (fromDate < toDate) {
                val diff = toDate.time - fromDate.time
                val totaldays = diff / (24 * 60 * 60 * 1000)
                val leave = totaldays * 0.083
                val vacation = leave.toInt()


                leaveDaysText.text = "Leave days: $vacation"
                leaveDaysText.text.toString()

            } else {
                leaveDaysText.setText("")
                Toast.makeText(this, "Invalid Dates! PLEASE CHECK YOUR FROM DATE", Toast.LENGTH_LONG).show()

            }
        }
    }

}