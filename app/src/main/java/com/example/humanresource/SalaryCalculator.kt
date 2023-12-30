package com.example.humanresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SalaryCalculator : AppCompatActivity() {

    private val WorkingDaysPerMonth = 26
    private val WorkingHourPerDay = 8
    private val NormalOvertimeRate = 1.25
    private val SpecialOvertimeRate = 1.5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salary_calculator)

        val etBasicSalary = findViewById<TextInputLayout>(R.id.etBasicSalary)
        val etFoodAllownace = findViewById<TextInputLayout>(R.id.etFoodAllownace)
        val etNormalOverTime = findViewById<TextInputLayout>(R.id.etNormalOverTime)
        val etFridayOvertime = findViewById<TextInputLayout>(R.id.etFridayOvertime)

        val btnNetSalary = findViewById<Button>(R.id.btnNetSalary)
        val txtviewNetSalary = findViewById<TextView>(R.id.txtviewNetSalary)

        btnNetSalary.setOnClickListener {
            val basicSalary = etBasicSalary.editText?.text.toString().toInt()
            val foodAllowance = etFoodAllownace.editText?.text.toString().toInt()
            val normalOvertimeHour = etNormalOverTime.editText?.text.toString().toInt()
            val fridayOvertimeHours = etFridayOvertime.editText?.text.toString().toInt()

            val hourlyPay = basicSalary / WorkingDaysPerMonth / WorkingHourPerDay
            val normalOvertimePayable = normalOvertimeHour * hourlyPay * NormalOvertimeRate
            val fridayOvertimePayable = fridayOvertimeHours * hourlyPay * SpecialOvertimeRate
            val salary = basicSalary + foodAllowance + normalOvertimePayable + fridayOvertimePayable


            txtviewNetSalary.text = "Net Salary: QR $salary"
        }
    }


}