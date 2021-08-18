import eva.Evaluator
import lexer.Lexer
import parser.Parser
import source.FileSource

fun main(args: Array<String>) {

    val source = FileSource("examples/simple.clc")
    if (!source.exists())
        error("file 'examples/simple.clc' nor exist")

    // infix :    2+3*6-9/10÷999.33688
    // postfix :  236*+910÷999.33688/-

    // infix :    2 + (3 * 6) - ((9 / 10) / 999.33688)+9
    // postfix :  236*+910/999.33688/-9+
    // postfix :  236*+910/999.33688/-9+

    // infix :    6+7-8*2+962/7
    // postfix :  67+82*-9627/+

    // infix :    1+2*3+5-6/7*8-9+3
    // postfix :  123*+5+67/8*-9-3+
    // postfix :  123*+5+678*/-93+-

    val lexer = Lexer(source)
    val parser = Parser(lexer)

    val evaluator = Evaluator(parser)
    println(
        lexer.readTokens().joinToString {
            it.value
        }
    )
    println(
        parser.parseTokens().joinToString("") {
            it.value
        }
    )
    println("Result = ${evaluator.evaluateResult()}")


//    val evaluator=Evaluator(parser)
//    println(evaluator.evaluateResult())

//    lexer.readTokens().forEach {
//        println(it)
//    }
//    val TOKENS_REGEX = "([()])|(\\d+(\\.\\d+)?)|([+*×÷/-])"
//
//    val lines = source.getLines()
//    val pattern = Pattern.compile(TOKENS_REGEX)
//    val matcher = pattern.matcher(lines.first())
//    println(
//        TOKENS_REGEX.toRegex()
//            .split(lines.first())
//            .filter { it.isNotBlank() }
//            .joinToString()
//    )
//    println(
//        TOKENS_REGEX.toRegex()
//            .findAll(lines.first())
//            .map { it.value }
//            .joinToString(",")
//    )
//        .split(lines.first())
//        .forEach { println(it) }

//    while (matcher.find()) {
//        val strToken = matcher.group()
//        if (strToken.isBlank())
//            continue
//        println(strToken)
//    }
//    matcher.find()

}