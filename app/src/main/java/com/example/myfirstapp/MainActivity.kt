package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.chrono.ChronoLocalDate
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(getDrawable(R.drawable.action_bar_bg))

        val npWeight: NumberPicker = findViewById(R.id.np_weight)
        val npHeight: NumberPicker = findViewById(R.id.np_height)
        val dpBirthday: DatePicker = findViewById(R.id.dp_birthday)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtName: EditText = findViewById(R.id.edtName)

        npWeight.minValue = 0
        npWeight.maxValue = 999
        npWeight.value = 50

        npHeight.minValue = 0
        npHeight.maxValue = 999
        npHeight.value = 170

        dpBirthday.maxDate = Calendar.getInstance().timeInMillis
        val date = Calendar.getInstance()

        var age: Int = 0
        dpBirthday.init(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH)) {
                _, year, month, day ->
            val birthday = LocalDate.of(year, month+1, day)
            age =   birthday.until(LocalDate.now(), ChronoUnit.YEARS).toInt()
        }


        btnCalculate.setOnClickListener {

            if (edtName.text.toString().isEmpty() || (age <= 0) || (npHeight.value <= 0) || (npWeight.value <= 0)){
                Toast.makeText(this, getString(R.string.fields_not_empty), Toast.LENGTH_LONG).show()
            } else{
                val height: Float = npHeight.value.toFloat() * 0.01F
                val weight: Float = npWeight.value.toFloat()
                val name: String = edtName.text.toString()

                val result = weight / (height * height)

                var user = User(name, height, weight, age, result)
                val intent = ResultActivity.start(this, user)

                startActivity(intent)
            }
        }
    }
}