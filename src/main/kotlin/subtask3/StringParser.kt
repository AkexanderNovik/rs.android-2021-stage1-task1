package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var i: Int = 0
        var ignoringIndexes: MutableList<Int> = emptyList<Int>().toMutableList()
        var resultArr: MutableList<String> = emptyList<String>().toMutableList()
        while(i<inputString.length) {
            for(j in ignoringIndexes) {
                if(i == j)
                {
                    i++
                }
            }
            when {
                inputString[i] == '(' -> {
                    ignoringIndexes.add(i)
                    resultArr.add(roundBracket(i+1, inputString))
                    i = 0
                }
                inputString[i] == '[' -> {
                    ignoringIndexes.add(i)
                    resultArr.add(squareBracket(i+1, inputString))
                    i = 0
                }
                inputString[i] == '<' -> {
                    ignoringIndexes.add(i)
                    resultArr.add(arrowBracket(i+1, inputString))
                    i = 0
                }
            }
            i++
        }

        for(j in resultArr) {
            println(j)
        }
        return resultArr.toTypedArray()
    }
    private fun squareBracket(index: Int, inputString: String): String {
        var openCount: Int = 0
        val result = StringBuilder()
        var loopEnd: Int = 0
        var i = index
        while(loopEnd != 1) {

            if(inputString[i] == '[') {
                result.append(inputString[i])
                openCount++
            } else if(inputString[i] != ']') {
                result.append(inputString[i])
            } else if(inputString[i] == ']' && openCount > 0) {
                result.append(inputString[i])
                openCount--
            } else {
                loopEnd = 1
            }
            i++
        }
        return result.toString()
    }
    private fun roundBracket(index: Int, inputString: String): String {
        var openCount: Int = 0
        val result = StringBuilder()
        var loopEnd: Int = 0
        var i = index
        while(loopEnd != 1) {
            if(inputString[i] == '(') {
                result.append(inputString[i])
                openCount++
            } else if(inputString[i] != ')') {
                result.append(inputString[i])
            } else if(inputString[i] == ')' && openCount > 0) {
                result.append(inputString[i])
                openCount--
            } else {
                loopEnd = 1
            }
            i++
        }
        return result.toString()
    }
    private fun arrowBracket(index: Int, inputString: String): String {
        var openCount: Int = 0
        val result = StringBuilder()
        var loopEnd: Int = 0
        var i: Int = index
        while(loopEnd != 1) {
            if(inputString[i] == '<') {
                result.append(inputString[i])
                openCount++
            } else if(inputString[i] != '>') {
                result.append(inputString[i])
            } else if(inputString[i] == '>' && openCount > 0) {
                result.append(inputString[i])
                openCount--
            } else {
                loopEnd = 1
            }
            i++
        }
        return result.toString()
    }
}
