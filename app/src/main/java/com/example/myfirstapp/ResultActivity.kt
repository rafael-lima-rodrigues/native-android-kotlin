package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        var classification = if (result <18.5f) "ABAIXO DO PESO"
        else if(result in 18.5f..24.9f) "NORMAL"
        else if(result in 25f..29.9f) "SOBREPESO"
        else if(result in 30f..39.9f) "OBESIDADE"
        else "OBESIDADE GRAVE"

        tvClassification.text = classification
    }
}