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

    fun evaluateResult(): EvaResult {
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
                    val result =
                        if (first is FunctionType.VariableFunction && second is FunctionType.VariableFunction)
                            token.evaluate(second.token, first.token)
                        else
                            token.evaluate(first, second)
                    stack.push(result)
                }
                is FunctionType -> {
                    token.calculateFunction(stack)
                }
                is FunctionType.VariableReference -> {
                    val refVar = stack.find {
                        (it is FunctionType.VariableFunction) && it.name == token.ref
                    } as FunctionType.VariableFunction
                    stack.push(refVar.token)
                }
                else -> {
                    error("Unexpected token at ${token.value}")
                }
            }
        }
        return EvaResult(stack)
    }
}