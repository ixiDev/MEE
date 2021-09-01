import lexer.Lexer
import parser.Parser
import source.FileSource

fun main() {

    val filePath="examples/example2.mee"
    val source = FileSource(filePath)
    if (!source.exists())
        error("file '$filePath' nor exist")

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
    val result = compiler.compile(source)
    println("result = $result")
}