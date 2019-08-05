package com.nemesis.course.completed.calculator

class Operation(val firstOperand:Double, val secondOperand: Double){

    enum class Operator{
        Addition,
        Substraction,
        Multiplication,
        Division;

        companion object{

            fun parseSymbol(symbol:String): Operator?{
                return when(symbol){
                    "+" -> Addition
                    "-" -> Substraction
                    "x" -> Multiplication
                    "/" -> Division
                    else -> null
                }
            }
        }

    }

    fun performOperation(operator: Operator): Double{
        return when(operator){
            Operator.Addition -> firstOperand + secondOperand

            Operator.Substraction -> firstOperand - secondOperand

            Operator.Multiplication -> firstOperand * secondOperand

            Operator.Division -> firstOperand / secondOperand
        }
    }
}