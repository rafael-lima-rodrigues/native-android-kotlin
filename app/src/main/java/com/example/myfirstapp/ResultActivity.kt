package com.example.myfirstapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classification = if (result <18.5f) getString(R.string.txt_under_weight)
        else if(result in 18.5f..24.9f) getString(R.string.txt_normal)
        else if(result in 25f..29.9f) getString(R.string.txt_overweight)
        else if(result in 30f..39.9f) getString(R.string.txt_obesity)
        else getString(R.string.txt_severe_obesity)

        tvClassification.text = getString(R.string.classification, classification)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish();
        return super.onOptionsItemSelected(item)
    }
}