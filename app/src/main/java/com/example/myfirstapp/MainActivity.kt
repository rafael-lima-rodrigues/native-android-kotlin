package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(getDrawable(R.drawable.action_bar_bg))

        val btnCalculate: Button = findViewById<Button>(R.id.btnCalculate)
        val edtWeight: EditText = findViewById<EditText>(R.id.edtWeight)
        val edtHeight: EditText = findViewById<EditText>(R.id.edtHeight)

        btnCalculate.setOnClickListener {

            if (edtHeight.text.toString().isEmpty() && edtWeight.text.toString().isEmpty()){
                Toast.makeText(this, getString(R.string.fields_not_empty), Toast.LENGTH_LONG).show()
            } else{
                val height: Float = edtHeight.text.toString().toFloat()
                val weight: Float = edtWeight.text.toString().toFloat()

                val result = weight / (height * height)

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }
        }
    }
}