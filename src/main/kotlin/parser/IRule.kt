package parser

import tokens.Token
import java.util.*

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/
interface IRule {
    fun validate(token: Token,queue: Queue<Token>, stack: Stack<Token>)
}