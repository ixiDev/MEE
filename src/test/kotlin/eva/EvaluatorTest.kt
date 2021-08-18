package eva

import org.junit.Test

import org.junit.Assert.*
import source.TextSource

/**
 * Author : Abdelmajid ID ALI
 * On : 17/08/2021
 * Email :  abdelmajid.idali@gmail.com
 */
class EvaluatorTest {

    @Test
    fun evaluateResult() {
        val evaluator = Evaluator(TextSource("2+3*6-9/10÷999.33688"))

        assertEquals(19.999099, evaluator.evaluateResult(), 0.0)
    }
}