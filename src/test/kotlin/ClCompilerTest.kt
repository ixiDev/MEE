import org.junit.Before
import org.junit.Test
import source.TextSource
import kotlin.test.assertEquals

/**
 * Author : Abdelmajid ID ALI
 * On : 17/08/2021
 * Email :  abdelmajid.idali@gmail.com
 */
class ClCompilerTest {

    private lateinit var compiler: ClCompiler

    private val sources = listOf(
        TextSource("1+2*3+5-6/7*8-9+3") to -0.857143,
        TextSource("2+3*6-9/10÷999.33688") to 19.999099,
        TextSource("2 + (3 * 6) - ((9 / 10) / 999.33688)") to 19.999099,
        TextSource("6+7-8*2+962/7") to 134.42857,
        TextSource("2+2") to 4.0,
        TextSource("log(9+ln(6*8))+7") to 8.109619,
        TextSource("log(9+ln(6*8)+7)") to 1.298224,
        TextSource("7-6*8+ln(6+7*9)*5+log(9+7)") to -18.625347,
        TextSource("7-6*8+ln(6+7*9)*5+log(9+7-ln(6+1))+6*7-88") to -64.681665,
        TextSource("exp(ln(6))") to 6.0,
        TextSource("6+6*exp(7-ln(6)+3*2)+log(7+exp(1*ln(6)))") to 442420.505952,
    )

    @Before
    fun setup() {
        compiler = ClCompiler()
    }

    @Test
    fun testCompile() {
        sources.forEach {
            try {
                assertEquals(
                    it.second,
                    compiler.compile(it.first),
                    "source : ${it.first.value} : "
                )
            } catch (e: Exception) {
                println("source : ${it.first.value} : ")
                e.printStackTrace()
            }

        }
    }

}