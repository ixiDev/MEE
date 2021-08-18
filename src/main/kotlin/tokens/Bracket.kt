package tokens

import isBracket
import java.util.*

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/

sealed class Bracket(name: String) : TokenType(name) {
    object LBracket : Bracket("(") {
        override fun validate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
            stack.push(token)
        }
    }

    object RBracket : Bracket(")") {
        override fun validate(token: Token, queue: Queue<Token>, stack: Stack<Token>) {
            if (stack.isEmpty())
                error("Brackets mismatch '${token.value}'")
            while (stack.peek().type != LBracket) {
                queue.add(stack.pop())
                if (stack.isEmpty())
                    error("Brackets mismatch '${token.value}'")
            }
            if (stack.peek().type != LBracket) {
                error("Brackets mismatch '${token.value}'")
            }
            stack.pop() // remove the opened bracket
        }
    }
}

fun String.toBracket(): Bracket {
    if (!this.isBracket())
        error("'$this' is not a Bracket")
    return if (this == ")")
        Bracket.RBracket
    else Bracket.LBracket
}