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
        var dotPresent: Boolean = false
        var operationNumber: String= ""
        var caNumber:String = ""
        var screenNumber: Int = 0
        var ansNumber: Int= 0
        var secNumber: Int= 0
        var performingOpe: CharSequence = ""
        var performing: Boolean = false
        var equal : Boolean = false



    fun numberClick(view: View){
        if (equal == false) {
            if (performing == false) {
                val button = view as Button
                val numString = button.text

                displayExpression.text = displayExpression.text.toString() + numString
//        operationNumber = displayExpression.text.toString()
            } else {
                val button = view as Button
                val numString = button.text

                displayResult.text = displayResult.text.toString() + numString
//          caNumber = displayResult.text.toString()
            }
        }

        else {
            displayExpression.text = ""
            displayResult.text = ""
            dotPresent= false
            performing = false
            equal == false
            operationNumber =""
            caNumber = ""
            screenNumber= 0
            ansNumber= 0
        }
    }

    fun dotClick(view: View) {
        if (dotPresent == false) {
            if (performing == false) {
                val button = view as Button
                val numString = button.text

                displayExpression.text = displayExpression.text.toString() + numString
                operationNumber = displayExpression.text.toString()
            } else {
                val button = view as Button
                val numString = button.text

                displayResult.text = displayResult.text.toString() + numString
                caNumber = displayResult.text.toString()
            }
            dotPresent = true
        }
    }


    fun operatorclick(view: View){
        val button = view as Button
        performingOpe = button.text
        ansNumber = operationNumber.toInt()
        performing = true


    }



    fun clearAll(view: View){
        displayExpression.text = ""
        displayResult.text = ""
        dotPresent= false
        performing = false
        equal == false
        operationNumber =""
        caNumber = ""
        screenNumber= 0
        ansNumber= 0
    }

    fun del(view: View){

            val string = displayExpression.text.toString()
            if (string.isNotEmpty()){
                displayExpression.text = string.substring(0,string.length-1)
            }
    }

    fun equalClick(){
        secNumber = caNumber.toInt()
        if (performingOpe == "+"){
            ansNumber +=  secNumber
        }
        else if (performingOpe == "-"){
            ansNumber -= secNumber
        }
        else if (performingOpe == "*"){
            ansNumber *= secNumber
        }
        else if (performingOpe == "÷"){
            ansNumber /= secNumber
        }
        displayResult.text = ansNumber.toString()
        displayExpression.text = ""
        equal = true

    }
    fun percentClick(){
        ansNumber /= 100
        displayResult.text = ansNumber.toString()
        displayExpression.text = ""
        equal = true
    }

}
