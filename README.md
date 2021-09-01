# MEE

MEE Math Expression Evaluator

----------
[![Build CI](https://github.com/ixiDev/MEE/actions/workflows/build.yml/badge.svg)](https://github.com/ixiDev/MEE/actions/workflows/build.yml)
[![Test CI](https://github.com/ixiDev/MEE/actions/workflows/test.yml/badge.svg)](https://github.com/ixiDev/MEE/actions/workflows/test.yml)
[![Release](https://jitpack.io/v/ixiDev/MEE.svg)](https://jitpack.io/#ixiDev/MEE)
-----------

### Examples

---------

#### Example 1 :

```kotlin
// create a text source from expression string
val source = TextSource("2^(2+6)*5+log(9+7-ln(6+1))")
// create compiler instance
val compiler = ClCompiler()

val result: Double = compiler.compile(source)
println("Result = $result")
```

```text
Output : 
    Result = 1281.147803
```

#### Example 2 :

---------
see [sample file](examples/sample.mee)

```kotlin
val filePath = "examples/sample.mee" // a simple Math expression script 
val source = FileSource(filePath)
val compiler = ClCompiler()
println("Result = ${compiler.compile(source)}")
```

For more simples take a look to [tests](src/test/kotlin) or to [Sample programme](src/main/kotlin/Main.kt)

## Supported symbols

|Supported|Symbol|Explanation|
|:---:|:---:|:---:|
| ✅ |**+**| Addition Operator eg. 2+3 results 5 |
| ✅ |**-**| Subtraction Operator eg. 2-3 results -1 |
| ✅ |**/ , ÷**| Division operator eg 3/2 results 1.5 |
| ✅ |**× ,***| Multiplication Operator eg. 2\*3 results 6 |
| ✅ |**(**| Opening Parenthesis |
| ✅ |**)**| Closing Parenthesis |
| ✅ |**=**| Assignment variables  eg. a = 22; |
| ✅ |**pi**| Math constant pi returns 3.14 |
| ✅ |**log**| logarithmic function with base 10 eg. log 1000 returns 3 |
| ✅ |**ln**| natural log function with base e eg. ln 2 returns .3010 |
| ✅ |**exp**|  exponential function |
| ✅ |**^**| power operator eg. 2^3 returns 8 |
| ✅ |**sqrt**| square root of a number eg. 4 returns 2 |
| ✅ |**sin**| Sine function |
| ✅ |**cos**| Cosine function |
| ⬜ |**pi**| Math constant pi returns 3.14 |
| ⬜ |**e**| Math constant e returns 2.71 |
| ⬜ |**tan**| Tangent function |
| ⬜ |**asin**| Inverse Sine function |
| ⬜ |**acos**| Inverse Cosine function |
| ⬜ |**atan**| Inverse Tangent function |
| ⬜ |**sinh**| Hyperbolic Sine function |
| ⬜ |**cosh**| Hyperbolic Cosine function |
| ⬜ |**tanh**| Hyperbolic Tangent function |
| ⬜ |**asinh**| Inverse Hyperbolic Sine function |
| ⬜ |**acosh**| Inverse Hyperbolic Cosine function |
| ⬜ |**atanh**| Inverse Hyperbolic Tangent function |
