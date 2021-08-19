package tokens

import isFloat
import isInt
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

fun String.toNumberType():Token{
    return if (this.isFloat())
        NumberType.FloatType(this)
    else if (this.isInt())
        NumberType.IntType(this)
    else error("not numner")

}
