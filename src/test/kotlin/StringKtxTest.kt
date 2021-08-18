import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Author : Abdelmajid ID ALI
 * On : 17/08/2021
 * Email :  abdelmajid.idali@gmail.com
 */
class StringKtxTest {


    @Test
    fun testKtxFun() {
        val strToken1 = "234"
        val strToken2 = "23.4"
        val strToken3 = "2.3.4"

        assertTrue("$strToken1 is not integer", strToken1.isInt())
        assertFalse("$strToken1 is not a float number", strToken1.isFloat())

        assertTrue("$strToken2 is not a float number", strToken2.isFloat())
        assertFalse("$strToken2 is not integer", strToken2.isInt())

        assertFalse("$strToken3 is not a float number", strToken3.isFloat())
        assertFalse("$strToken3 is not a float number", strToken3.isNumber())
        assertFalse("$strToken3 is not integer", strToken3.isInt())
    }

}