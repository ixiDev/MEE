package tokens

import parser.IRule

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/

sealed class TokenType(private val name: String) : IRule {
    override fun toString(): String {
        return name
    }
}
