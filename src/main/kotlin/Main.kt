import eva.Evaluator
import lexer.Lexer
import parser.Parser
import source.FileSource

fun main(args: Array<String>) {

    val source = FileSource("examples/example2.mee")
    if (!source.exists())
        error("file 'examples/example2.mee' nor exist")

    val lexer = Lexer(source)

    val parser = Parser(lexer)

    val evaluator = Evaluator(parser)
    println(
       "Infix : "+ lexer.readTokens().joinToString("") {
            it.value
        }
    )
    println(
        "PostFix : " + parser.parseTokens().joinToString("") {
            it.value
        }
    )
    println("Result = ${evaluator.evaluateResult()}")


}