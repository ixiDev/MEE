package eva

import lexer.Lexer
import tokens.*
import parser.Parser
import source.ISource
import java.util.*
import kotlin.math.ln

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/
class Evaluator(private val parser: Parser) {


    constructor(source: ISource) : this(
        Parser(
            Lexer(source)
        )
    )


    fun evaluateResult(): Double {
        val tokens = parser.parseTokens()
        val stack = Stack<Token>()
        while (tokens.isNotEmpty()) {
            when (val token = tokens.poll()) {
                is NumberType -> {
                    stack.push(token)
                }
                is Operation -> {
                    val first: Token = stack.pop() ?: NumberType.IntType("0")
                    var second: Token = NumberType.IntType("0")
                    if (stack.isNotEmpty())
                        second = stack.pop()
                    val result = token.evaluate(first, second)
                    stack.add(result)
                }
                is FunctionType -> {
                    token.onEvaluate(token, tokens, stack)
                }
                else -> {
                    error("Unexpected token at ${token.value}")
                }
            }
        }

        if (stack.isEmpty())
            return 0.0
        val pop = stack.pop().value.toDouble()
        val result = String.format("%.6f", pop)
        return result.toDouble()
    }
}