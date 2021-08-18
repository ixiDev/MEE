package source

import removeComments

class TextSource(private val value: String) : ISource {
    override fun getLines(): List<String> {
        return value.split("\n").removeComments()
    }
}