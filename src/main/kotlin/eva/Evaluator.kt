package eva

import lexer.Lexer
import parser.Parser
import source.ISource
import tokens.*
import java.util.*

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
                    if (stack.isEmpty())
                        error("Operation $token not allowed in empty stack")
                    val first: Token = stack.pop()
                    val second: Token = stack.pop()
                    val result = token.evaluate(first, second)
                    stack.push(result)
                }
                is FunctionType -> {
                    token.calculateFunction(stack)
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