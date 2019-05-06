package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun bunumberEvent(view:View){
        if (isNewOp){
            displayResult.setText("")
        }
        isNewOp=false

        val buSelect = view as Button
        var buClickValue:String = displayResult.text.toString()

        when(buSelect.id){
            zero.id->{
                if (displayResult.text.toString().endsWith("0")){
                    displayResult.setText("")
                }else {
                    buClickValue+="0"
                }
            }
            one.id->{
                buClickValue+="1"
            }
            two.id->{
                buClickValue+="2"
            }
            three.id->{
                buClickValue+="3"
            }
            four.id->{
                buClickValue+="4"
            }
            five.id->{
                buClickValue+="5"
            }
            six.id->{
                buClickValue+="6"
            }
            seven.id->{
                buClickValue+="7"
            }
            eight.id->{
                buClickValue+="8"
            }
            nine.id->{
                buClickValue+="9"
            }
            dot.id->{
                if (displayResult.text.toString().endsWith(".")){
                    displayResult.setText("")
                }else {
                    buClickValue+="."
                }
            }
            sign.id->{
                buClickValue="-" + buClickValue
            }
        }
        displayResult.setText(buClickValue)
    }

    var op="*"
    var oldNumber=""
    var isNewOp =true
    fun buOpEvent(view: View) {
        val buSelect = view as Button

        when (buSelect.id) {
            mul.id -> {
                op = "*"
            }

            div.id -> {
                op = "÷"
            }

            sub.id -> {
                op = "-"

            }
            add.id -> {
                op = "+"

            }

        }
        oldNumber=displayResult.text.toString()
        isNewOp=true
    }

    fun buEqualEvent(view: View){
        val newNumber=displayResult.text.toString()
        var answer:Double?=null
        when(op){
            "*"->{
                answer=oldNumber.toDouble() * newNumber.toDouble()

            }
            "÷"->{
                answer=oldNumber.toDouble() / newNumber.toDouble()

            }
            "+"->{
                answer=oldNumber.toDouble() + newNumber.toDouble()

            }
            "-"->{
                answer=oldNumber.toDouble() - newNumber.toDouble()

            }
        }

        displayResult.setText(answer.toString())
        isNewOp=true

    }

    fun bupercent(view: View){
        val number:Double=displayResult.text.toString().toDouble()/100
        displayResult.setText(number.toString())
        isNewOp=true
    }

    fun buClean(view: View){
        displayResult.setText("")
        isNewOp=true
    }
}
