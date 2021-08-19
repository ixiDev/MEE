package tokens

import java.lang.Math.pow
import java.util.*
import kotlin.math.*

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/

sealed class FunctionType(name: String) : Token(value = name, priority = 6) {

    override fun onParse(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
        stack.push(token)
    }

    override fun onEvaluate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
        TODO("Not yet implemented")
    }

    abstract fun calculateFunction(stack: Stack<Token>)

    object LogFunction : FunctionType("log") {
        override fun calculateFunction(stack: Stack<Token>) {
            val result = log10(stack.pop().value.toDouble())
            stack.push(
                NumberType.FloatType("$result")
            )
        }
    }

    object LnFunction : FunctionType("ln") {
        override fun calculateFunction(stack: Stack<Token>) {
            val result = ln(stack.pop().value.toDouble())
            stack.push(
                NumberType.FloatType("$result")
            )
        }
    }

    object ExpFunction : FunctionType("exp") {
        override fun calculateFunction(stack: Stack<Token>) {
            val result = exp(stack.pop().value.toDouble())
            stack.push(
                NumberType.FloatType("$result")
            )
        }
    }

    object CosFunction : FunctionType("cos") {
        override fun calculateFunction(stack: Stack<Token>) {
            val result = cos(stack.pop().value.toDouble())
            stack.push(
                NumberType.FloatType("$result")
            )
        }
    }

    object SinFunction : FunctionType("sin") {
        override fun calculateFunction(stack: Stack<Token>) {
            val result = sin(stack.pop().value.toDouble())
            stack.push(
                NumberType.FloatType("$result")
            )
        }
    }

    object SqrtFunction : FunctionType("sqrt") {
        override fun calculateFunction(stack: Stack<Token>) {
            val result = sqrt(stack.pop().value.toDouble())
            stack.push(
                NumberType.FloatType("$result")
            )
        }
    }
}

fun String.isMathFun(): Boolean {
    return this.matches(
        "(log)|(ln)|(exp)|(cos)|(sin)|(sqrt)".toRegex()
    )
}

fun String.toMathFun(): FunctionType {
    return when (this) {
        "log", "Log", "LOG" -> FunctionType.LogFunction
        "ln", "Ln", "LN" -> FunctionType.LnFunction
        "exp", "Exp", "EXP" -> FunctionType.ExpFunction
        "cos", "Cos", "COS" -> FunctionType.CosFunction
        "sin", "Sin", "SIN" -> FunctionType.SinFunction
        "sqrt", "Sqrt", "SQRT" -> FunctionType.SqrtFunction
        else -> error("Unsupported function '$this'")
    }
}

