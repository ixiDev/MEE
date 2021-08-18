package tokens

import java.util.*


sealed class NumberType(
    value: String
) : Token(value) {
    data class FloatType(private val number: String) : NumberType(number)
    data class IntType(private val number: String) : NumberType(number)

    override fun validate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
        queue.add(token)
    }
}