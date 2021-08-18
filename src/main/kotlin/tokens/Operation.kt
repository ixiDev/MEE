package tokens

import java.util.*

/**
 * Author : Abdelmajid ID ALI
 * On : 17/08/2021
 * Email :  abdelmajid.idali@gmail.com
 **/
sealed class Operation(name: String, val priority: Int) : TokenType(name) {
    object Subtraction : Operation("Subtraction", 0)
    object Addition : Operation("Addition", 0)
    object Division : Operation("Division", 3)
    object Multiplication : Operation("Multiplication", 3)

    fun evaluate(first: Token, second: Token): Token {
        return when (this) {
            Addition -> first + second
            Subtraction -> first - second
            Division -> first / second
            Multiplication -> first * second
        }
    }

    override fun validate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {

//        println("${this == token.type}") always true

// 123*+5+67/8*-9-3+
        if (stack.isEmpty()) {
            stack.push(token)
        } else {
            val top = stack.peek()
            if (top.type !is Operation) {
                stack.push(token)
                return
            }
            val topOperation = top.type
            if (topOperation.priority < this.priority) {
                stack.push(token)
            } else if (topOperation.priority == this.priority) {
                queue.add(stack.pop())
                stack.push(token)
            } else {
                while (
                    stack.isNotEmpty() &&
                    stack.peek().type is Operation &&
                    (stack.peek().type as Operation).priority >= this.priority
                ) {

                    queue.add(stack.pop())
                }
//                queue.add(stack.pop())
                stack.push(token)
            }
        }


//      else {
//            val top = stack.peek()
//            val topPriority = (top.type as Operation).priority
//            val tokenPriority = (token.type as Operation).priority


//            when  {
//               ( top.type is Operation ) and (token.type is Operation)-> {
//                    if (top.type.priority > token.type.priority) {
//                        while (stack.isNotEmpty())
//                            queue.add(stack.pop())
//                        stack.push(token)
//                    } else if (top.type.priority == token.type.priority) {
//                        queue.add(token)
//                    } else {
//                        queue.add(stack.pop())
//                        stack.push(token)
//                    }
//                }
//                else -> {
//                    stack.push(token)
//                }
//            }
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

//operator fun Operation.equals(operation: Operation): Int {
//    return priority == priority
//}
