package tokens

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/
data class Token(
    val type: TokenType,
    val value: String,
)

operator fun Token.plus(token: Token): Token {
    if (this.type is NumberType && token.type is NumberType) {
        return if (value.contains(".") or token.value.contains("."))
            Token(
                type = NumberType.FloatType,
                value = "${token.value.toDouble() + value.toDouble()}"
            )
        else Token(
            type = NumberType.IntType,
            value = "${token.value.toInt() + value.toInt()}"
        )
    }
    error("Plus operation not allowed in tokens '$this' and '$token' ")
}

operator fun Token.minus(token: Token): Token {
    if (this.type is NumberType && token.type is NumberType) {
        return if (value.contains(".") or token.value.contains("."))
            Token(
                type = NumberType.FloatType,
                value = "${token.value.toDouble() - value.toDouble()}"
            )
        else Token(
            type = NumberType.IntType,
            value = "${token.value.toInt() - value.toInt()}"
        )
    }
    error("minus operation not allowed in tokens '$this' and '$token' ")
}

operator fun Token.times(token: Token): Token {
    if (this.type is NumberType && token.type is NumberType) {
        return if (value.contains(".") or token.value.contains("."))
            Token(
                type = NumberType.FloatType,
                value = "${token.value.toDouble() * value.toDouble()}"
            )
        else Token(
            type = NumberType.IntType,
            value = "${token.value.toInt() * value.toInt()}"
        )
    }
    error("minus operation not allowed in tokens '$this' and '$token' ")
}

operator fun Token.div(token: Token): Token {
    if (this.type is NumberType && token.type is NumberType) {
        return Token(
            type = NumberType.FloatType,
            value = "${token.value.toFloat() / value.toFloat()}"
        )
    }
    error("minus operation not allowed in tokens '$this' and '$token' ")
}