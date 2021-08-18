package tokens

import java.util.*


sealed class NumberType(
    value: String
) : Token(value) {
    data class FloatType(private val number: String) : NumberType(number)
    data class IntType(private val number: String) : NumberType(number)

    override fun onParse(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
        queue.add(token)
    }

    override fun onEvaluate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
        TODO("Not yet implemented")
    }
}