package source

interface ISource {
    fun getLines(): List<String>
    fun getText():String
}