package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById<Button>(R.id.btnCalculate)
        val edtWeight: EditText = findViewById<EditText>(R.id.edtWeight)
        val edtHeight: EditText = findViewById<EditText>(R.id.edtHeight)
        var tvResult = findViewById<TextView>(R.id.txtResult)

        btnCalculate.setOnClickListener {
            val altura: Float = edtHeight.text.toString().toFloat()
            val peso: Float = edtWeight.text.toString().toFloat()

            val result = peso / (altura * altura)
            tvResult.text = result.toString()
            println("RESULTADO = " + result)

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(intent)
        }
    }
}