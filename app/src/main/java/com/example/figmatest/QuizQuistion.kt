package com.example.figmatest

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_quistion.*
import org.w3c.dom.Text
import kotlin.math.log

class QuizQuistion : AppCompatActivity() , View.OnClickListener {
    private var mCurrentPosition:Int = 1
    private var mQuistionList:ArrayList<Questions> ?= null
    private  var mSelectedOpstion: Int = 0
    public var mCurrectAnswer:Int =0
    private var mUserName:String?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_quistion)
        mUserName = intent.getStringExtra(Constant.USER_NAME)
        mQuistionList = Constant.getQuestion()


        ops1.setOnClickListener (this)
        ops2.setOnClickListener (this)
        ops3.setOnClickListener (this)
        ops4.setOnClickListener (this)
        btn_subm.setOnClickListener (this)
        getQuestions()
    }
    private fun getQuestions(){

        var qui:Questions = mQuistionList!![mCurrentPosition - 1]
        defaultView()
        if(mCurrentPosition == mQuistionList!!.size ){
            btn_subm.text = "Finish"
        }else{
            btn_subm.text = "SUBMIT"
        }
        //progress bar setting
        prog.progress = mCurrentPosition
        SHOW_PROGRESS.text = "$mCurrentPosition / ${prog.max}"

        //image resorce
        Flag.setImageResource(qui.image)

        //quistions text
        quistions.text = qui.question

        ops1.text = qui.Option1
        ops2.text = qui.Option2
        ops3.text = qui.option3
        ops4.text = qui.option4

    }
    private fun defaultView (){
        var opsion = ArrayList<TextView>()

        opsion.add(0,ops1)
        opsion.add(1,ops2)
        opsion.add(2,ops3)
        opsion.add(3,ops4)
        for (item in opsion){
            item.background = ContextCompat.getDrawable(this,R.drawable.edittextborder)
            item.typeface = Typeface.DEFAULT
            item.setTextColor(Color.parseColor("#030303"))


        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.ops1 -> {SelectOpsion(ops1,1)}
            R.id.ops2 ->{SelectOpsion(ops2,2)}
            R.id.ops3 ->{SelectOpsion(ops3,3)}
            R.id.ops4 ->{SelectOpsion(ops4,4)}
            R.id.btn_subm -> {
                if(mSelectedOpstion == 0){
                    mCurrentPosition ++
                    when{
                        mCurrentPosition <= mQuistionList!!.size  ->{
                            getQuestions()
                        }else ->{

                        var resultIntent = Intent(this,ResultActivity::class.java)
                        resultIntent.putExtra(Constant.USER_NAME,mUserName)
                        resultIntent.putExtra(Constant.CORRECT_ANSWERS,mCurrectAnswer)
                        resultIntent.putExtra(Constant.Total_Quistion,mQuistionList!!.size)
                        startActivity(resultIntent)
                        finish()
                        }
                    }
                }else{
                    val quis = mQuistionList!![mCurrentPosition -1]
                    if(quis!!.answer != mSelectedOpstion){
                        Answ(mSelectedOpstion,R.drawable.wrongboarder)
                    }else{
                        mCurrectAnswer ++
                    }
                    Answ(quis.answer,R.drawable.correctboarder)
                    if(mCurrentPosition == mQuistionList!!.size){
                        btn_subm.text = "Finish"
                    }else{
                        btn_subm.text = "Next Question"
                    }
                    mSelectedOpstion =0
                }
            }
        }
    }

    private fun Answ (answer:Int,drawableSo:Int){
        when(answer){
            1 -> {ops1.background = ContextCompat.getDrawable(this ,drawableSo)}
            2 -> {ops2.background = ContextCompat.getDrawable(this,drawableSo)}
            3 -> {ops3.background = ContextCompat.getDrawable(this,drawableSo)}
            4 -> {ops4.background = ContextCompat.getDrawable(this,drawableSo)}
        }
    }
    private fun SelectOpsion(tv:TextView,selectedOpstion:Int){
        defaultView()
        mSelectedOpstion = selectedOpstion
        tv.background = ContextCompat.getDrawable(this,R.drawable.edittextborder)
        tv.setTypeface(tv.typeface , Typeface.BOLD)
        tv.setTextColor(Color.parseColor(("#9d41fd")))
    }
}