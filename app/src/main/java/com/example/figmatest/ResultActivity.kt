package com.example.figmatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val user_name = intent.getStringExtra(Constant.USER_NAME)
        val totalScore = intent.getIntExtra(Constant.Total_Quistion,0)
        val answer = intent.getIntExtra(Constant.CORRECT_ANSWERS,0)

        User.text = user_name
        score.text = "your score is $answer of $totalScore"
        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}