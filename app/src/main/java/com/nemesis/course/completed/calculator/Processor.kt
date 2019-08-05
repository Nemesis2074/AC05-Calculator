package com.nemesis.course.completed.calculator

class Processor {

    private var accumulator:Double? = null

    private var operator:Operation.Operator? = null

    fun setOperand(operand: Double){
        accumulator = operand
    }

    fun setOperation(symbol:String){
        operator = Operation.Operator.parseSymbol(symbol)
    }

    fun performOperation(secondOperand:Double){

        val accumulator = this.accumulator
        val operator = this.operator

        if( accumulator != null && operator != null){
            val operation = Operation(accumulator, secondOperand)
            this.accumulator = operation.performOperation(operator)
        }
    }

    fun hasFirstOperand(): Boolean{
        return accumulator != null
    }

    fun getResult(): Double{
        return accumulator ?: 0.0
    }

    fun clear(){
        accumulator = null
        operator = null
    }

}