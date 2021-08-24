package parser

import lexer.*
import tokens.*
import java.util.*

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/
class Parser(private val lexer: Lexer) {

    /**
     * Convert infix tokens to postfix tokens
     */
    fun parseTokens(): Queue<Token> {
        val tokens: Queue<Token> = LinkedList(lexer.readTokens())
        val stack = Stack<Token>()
        val queue: Queue<Token> = LinkedList()
        while (tokens.isNotEmpty()) {
            val token = tokens.poll()
            token.onParse(tokens, queue, stack)
        }
        while (stack.isNotEmpty()) {
            queue.add(stack.pop())
        }
        return queue
    }


    private fun parserError(message: String): Nothing = error("[Parser]: error: $message")
}