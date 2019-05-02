package com.example.calculator

class calculatorString{
    fun calculate(calculateList: List<String>): Int {
        var currentOp  = ""
        var currentNumber = 0

        calculateList.forEach{ token ->

            when {
                token.equals("+")
                        || token.equals("-")
                        || token.equals("*")
                        || token.equals("÷") -> currentOp = token

                currentOp.equals("-") -> currentNumber -= token.toInt()
                currentOp.equals("÷") -> currentNumber /= token.toInt()
                currentOp.equals("*") -> currentNumber *= token.toInt()

            else -> currentNumber += token.toInt()

            }

        }
return currentNumber

    }
}