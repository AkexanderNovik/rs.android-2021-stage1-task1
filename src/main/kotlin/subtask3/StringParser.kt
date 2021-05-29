package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        var i = 0
        var ignoredIndexes = mutableListOf<Int>()
        var result = mutableListOf<String>()
        while (i < inputString.length) {
            for (j in ignoredIndexes) {
                if (i == j) i++
            }
            when {
                inputString[i] == '(' -> {
                    ignoredIndexes.add(i)
                    result.add(traverseString(i + 1, inputString, '(', ')'))
                    i = 0
                }
                inputString[i] == '[' -> {
                    ignoredIndexes.add(i)
                    result.add(traverseString(i + 1, inputString, '[', ']'))
                    i = 0
                }
                inputString[i] == '<' -> {
                    ignoredIndexes.add(i)
                    result.add(traverseString(i + 1, inputString, '<', '>'))
                    i = 0
                }
            }
            i++
        }
        return result.toTypedArray()
    }

    private fun traverseString(
        index: Int,
        inputString: String,
        openedBracket: Char,
        closedBracket: Char
    ): String {
        var count = 0
        val result = StringBuilder()
        var loopEnd = 0
        var y = index
        while (loopEnd != 1) {
            when {
                inputString[y] == openedBracket -> {
                    result.append(inputString[y])
                    count++
                }
                inputString[y] != closedBracket -> {
                    result.append(inputString[y])
                }
                inputString[y] == closedBracket && count > 0 -> {
                    result.append(inputString[y])
                    count--
                }
                else -> loopEnd = 1
            }
            y++
        }
        return result.toString()
    }
}
