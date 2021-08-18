package tokens

import java.util.*

/**
 * Author : Abdelmajid ID ALI
 * On : 17/08/2021
 * Email :  abdelmajid.idali@gmail.com
 **/
sealed class Operation(value: String, priority: Int) : Token(value, priority) {
    object Subtraction : Operation("-", 1)
    object Addition : Operation("+", 1)
    object Division : Operation("/", 2)
    object Multiplication : Operation("*", 2)

    fun evaluate(first: Token, second: Token): Token {
        return when (this) {
            Addition -> first + second
            Subtraction -> first - second
            Division -> first / second
            Multiplication -> first * second
        }
    }

    override fun validate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {

        if (stack.isEmpty()) {
            stack.push(token)
        } else {
            val top = stack.peek()
            if (top !is Operation) {
                stack.push(token)
                return
            }
            if (top.priority < this.priority) {
                stack.push(token)
            } else if (top.priority == this.priority) {
                queue.add(stack.pop())
                stack.push(token)
            } else {
                while (
                    stack.isNotEmpty() &&
                    stack.peek() is Operation &&
                    (stack.peek() as Operation).priority >= this.priority
                ) {
                    queue.add(stack.pop())
                }
                stack.push(token)
            }
        }

    }
}

fun String.toOperation(): Operation {
    return when (this) {
        "+" -> Operation.Addition
        "-" -> Operation.Subtraction
        "*", "×" -> Operation.Multiplication
        "/", "÷" -> Operation.Division
        else -> error("lexer:String.toOperation, $this is not an operation")
    }
}

operator fun Operation.compareTo(operation: Operation): Int {
    return priority.compareTo(operation.priority)
}