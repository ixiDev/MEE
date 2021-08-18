package tokens

import java.util.*
import kotlin.math.ln
import kotlin.math.log
import kotlin.math.log10

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/

sealed class FunctionType(name: String) : Token(value = name) {

    override fun onParse(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
        queue.add(token)
    }

    override fun onEvaluate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
        if (queue.isNotEmpty() and (queue.peek() !is Operation)) {
            while (queue.isNotEmpty() && queue.peek() !is Operation) {
                stack.push(queue.poll())
            }
            while (queue.isNotEmpty() && queue.peek() is Operation) {
                val first: Token = stack.pop() ?: NumberType.IntType("0")
                var second: Token = NumberType.IntType("0")
                if (stack.isNotEmpty())
                    second = stack.pop()
                val result = (queue.poll() as Operation).evaluate(first, second)
                stack.add(result)
            }
            LogFunction.calculateFunction(stack)
        } else {
            LogFunction.calculateFunction(stack)
        }
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
}

fun String.isMathFun(): Boolean {
    return this.matches("(log)".toRegex())
}

fun String.toMathFun(): FunctionType {
    return when (this) {
        "log", "Log", "LOG" -> FunctionType.LogFunction
        else -> error("Unsupported function '$this'")
    }
}

