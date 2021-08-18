import eva.Evaluator
import source.ISource

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/
class ClCompiler {


    fun compile(source:ISource):Double{
        val evaluator=Evaluator(source)
        return evaluator.evaluateResult()
    }
}