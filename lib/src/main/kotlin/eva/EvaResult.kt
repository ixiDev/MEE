package eva

import tokens.FunctionType
import tokens.Token
import java.util.*

/**
 ** Author : Abdelmajid ID ALI
 ** On : 24/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/

data class EvaResult(
    /**
     * Stack of results
     */
    val results: Stack<Token>
)

fun EvaResult.getLastResult(): Token {
    if (results.isEmpty())
        error("Results stack empty")
    return results.peek()
}

fun EvaResult.getLastResultValue(): Double {
    if (results.isEmpty())
        error("Results stack empty")
    val pop = getLastResult()
    val db = if (pop is FunctionType.VariableFunction) {
        pop.token.value.toDouble()
    } else pop.value.toDouble()
    val result = String.format("%.6f", db)
    return result.toDouble()
}
