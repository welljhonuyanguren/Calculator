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
        updateUI(mainUIString= "")


        back.setOnClickListener {
            val string = displayExpression.text.toString()
            if (string.isNotEmpty()){
                displayExpression.text = string.substring(0,string.length-1)
            }
        }

        dot.setOnClickListener{
            if(dotPresent == false){
                displayExpression.text = displayExpression.text.toString() +"."
                dotPresent= true }
        }

    }
        var dotPresent: Boolean = false
        val operationNumber: MutableList<String> = arrayListOf()
        val caNumber: MutableList<String> = arrayListOf()
        var screenNumber: Int= 0
        var ansNumber: Int= 0
        var performingNum: Boolean = false






    private fun extractString (items: List<String>, connect:String = ""): String {
        if(items.isEmpty()) return ""
        return items.reduce {acc, s -> acc + connect + s}
    }

    private fun updateUI(mainUIString: String){
        val calculationString= extractString(operationNumber, connect= "" )
        var calculationText = findViewById<View>(R.id.displayExpression) as TextView

        calculationText.text = calculationString

        val ans = findViewById<View>(R.id.displayResult) as TextView
        ans.text = mainUIString
    }

    fun numberClick(view: View){
        val button = view as Button
        val numString = button.text

        caNumber.add(numString.toString())
        val text = extractString(caNumber)
        updateUI(text)

    }

    fun operatorclick(view: View){
        val button = view as Button
        if (caNumber.isEmpty()) return

        operationNumber.add(extractString(caNumber))
        caNumber.clear()
      //  operationNumber.add(button.text.toString())
        updateUI(button.text.toString())
    }

    private fun clearview(){
        operationNumber.clear()
        caNumber.clear()
        dotPresent= false
    }

    fun clearAll(view: View){
        clearview()
        updateUI(mainUIString= "")
    }

    fun equalClick(){
        operationNumber.add(extractString(caNumber))
        caNumber.clear()

        val calculator = calculatorString()
        val answer = calculator.calculate(operationNumber)
        updateUI(mainUIString= "=" + answer.toString())
        clearview()
    }

}
