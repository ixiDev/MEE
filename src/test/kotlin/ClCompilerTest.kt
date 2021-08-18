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
        TextSource("2+3*6-9/10÷999.33688") to 19.999099,
        TextSource("2 + (3 * 6) - ((9 / 10) / 999.33688)") to 19.999099,
        TextSource("6+7-8*2+962/7") to 134.42857,
        TextSource("2+2") to 4.0
    )

    @Before
    fun setup() {
        compiler = ClCompiler()
    }

    @Test
    fun testCompile() {
        sources.forEach {
            assertEquals(it.second, compiler.compile(it.first))

        }
    }

}