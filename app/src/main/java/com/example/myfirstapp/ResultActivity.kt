package com.example.myfirstapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val user = intent.getSerializableExtra(USER_DETAIL_EXTRA) as User
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(getDrawable(R.drawable.action_bar_bg))


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvName = findViewById<TextView>(R.id.textview_name)
        val tvAge = findViewById<TextView>(R.id.textview_age)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)


        tvResult.text = user.bmi.toString()

        val classification = if (user.bmi < 18.5f) getString(R.string.txt_under_weight)
        else if(user.bmi in 18.5f..24.9f) getString(R.string.txt_normal)
        else if(user.bmi in 25f..29.9f) getString(R.string.txt_overweight)
        else if(user.bmi in 30f..39.9f) getString(R.string.txt_obesity)
        else getString(R.string.txt_severe_obesity)

        tvName.text = getString(R.string.name_result, user.name)
        tvAge.text = getString(R.string.result_age, user.age.toString())
        tvClassification.text = getString(R.string.classification, classification)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    companion object{
        private const val USER_DETAIL_EXTRA = "user.extra.detail"
        fun start(context: Context, user: User): Intent {
            val intent = Intent(context, ResultActivity::class.java)
                .apply {
                    putExtra(USER_DETAIL_EXTRA, user)
                }
            return intent
        }
    }
}