package tokens

import java.util.*

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/

sealed class FunctionType(name: String) : TokenType(name) {
    object LogFunction : FunctionType("log") {
        override fun validate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
            queue.add(stack.pop())
            stack.push(token)
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

