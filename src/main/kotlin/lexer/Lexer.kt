package lexer

import isBracket
import isFloat
import isInt
import isOperation
import source.ISource
import tokens.*

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/

private  val TOKENS_REGEX:String
    get()="""
        ([()])|(\d+(\.\d+)?)|([+*×÷/-])|log
    """.trimIndent()

class Lexer(private val source: ISource) {

    fun readTokens(): List<Token> {
        if (source.getLines().isEmpty())
            return emptyList()

        val lines = source.getLines()
        val regex = TOKENS_REGEX.toRegex()

        val nonAllowedTokens = regex.split(lines.first())
            .filter { it.isNotBlank() && it != "\n" && it != " " }

        if (nonAllowedTokens.isNotEmpty()) {
            lexerError(" Symbols [${nonAllowedTokens.joinToString()}] not allowed")
        }

        val tokens = ArrayList<Token>()

        regex.findAll(lines.first())
            .filter { it.value.isNotBlank() }
            .forEach {
                val strToken = it.value
                val token: Token = when {
                    strToken.isInt() -> Token(NumberType.IntType, strToken)
                    strToken.isFloat() -> Token(NumberType.FloatType, strToken)
                    strToken.isOperation() -> Token(strToken.toOperation(), strToken)
                    strToken.isBracket() -> Token(strToken.toBracket(), strToken)
                    strToken.isMathFun() -> Token(strToken.toMathFun(), strToken)
                    else -> {
                        lexerError("keyword '$strToken' not allowed")
                    }
                }
                tokens.add(token)
            }

        return tokens
    }

    private fun lexerError(message: String): Nothing = error("[Lexer] error : $message")
}