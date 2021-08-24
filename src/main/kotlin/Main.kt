import lexer.Lexer
import parser.Parser
import source.FileSource

fun main() {

    val source = FileSource("examples/example2.mee")
    if (!source.exists())
        error("file 'examples/example2.mee' nor exist")

    val lexer = Lexer(source)

    val parser = Parser(lexer)

    println(
        "Infix : " + lexer.readTokens().joinToString("") {
            it.value
        }
    )
    println(
        "PostFix : " + parser.parseTokens().joinToString("") {
            it.value
        }
    )
    val compiler = ClCompiler()
    println("Result = ${compiler.compile(source)}")


}