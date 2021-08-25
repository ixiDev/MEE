import eva.EvaResult
import eva.Evaluator
import eva.getLastResultValue
import source.ISource

/**
 ** Author : Abdelmajid ID ALI
 ** On : 17/08/2021
 ** Email :  abdelmajid.idali@gmail.com
 **/
class ClCompiler {


    fun compile(source: ISource): Double {
        return fullResult(source).getLastResultValue()
    }

    fun fullResult(source: ISource): EvaResult {
        val evaluator = Evaluator(source)
        return evaluator.evaluateResult()
    }
}