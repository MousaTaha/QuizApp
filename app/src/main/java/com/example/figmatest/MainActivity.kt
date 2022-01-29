package com.example.figmatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        start_btn.setOnClickListener {
            if (name_edit.text.toString().isEmpty()){
                Toast.makeText(this, "enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val quizintent = Intent(this,QuizQuistion::class.java)

                quizintent.putExtra(Constant.USER_NAME,name_edit.text.toString())
                startActivity(quizintent)
                println("continue")
                finish()
            }
        }
    }
}