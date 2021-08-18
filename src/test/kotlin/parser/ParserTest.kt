package parser

import lexer.Lexer
import org.junit.Test

import org.junit.Assert.*
import source.TextSource

/**
 * Author : Abdelmajid ID ALI
 * On : 18/08/2021
 * Email :  abdelmajid.idali@gmail.com
 */
class ParserTest {

    private val sources = listOf(
        TextSource("1+2*3+5-6/7*8-9+3") to "123*+5+67/8*-9-3+",
        TextSource("6+7-8*2+962/7") to "67+82*-9627/+",
        TextSource("2+3*6-9/10/999.33688") to "236*+910/999.33688/-",
        TextSource("2 + (3 * 6) - ((9 / 10) / 999.33688)+9*7") to "236*+910/999.33688/-97*+",
        TextSource("8+1+2+3-3-7-8") to "81+2+3+3-7-8-",
        TextSource("7-6*8+ln(6+7*9)*5+log(9+7)") to "768*-ln679*+5*+log97++",
    )

    @Test
    fun parseTokens() {
        for (source in sources) {
            val parser = Parser(Lexer(source = source.first))
            assertEquals(
                parser.parseTokens().joinToString("") { it.value },
                source.second
            )
        }

    }
}