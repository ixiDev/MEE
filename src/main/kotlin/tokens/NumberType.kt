package tokens

import java.util.*


sealed class NumberType(name: String = "NumberType") : TokenType(name) {
    object FloatType : NumberType("FloatType")
    object IntType : NumberType("IntType")

    override fun validate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
        queue.add(token)
    }
}