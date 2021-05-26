package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val array = mutableListOf<Int>()

        return if (sadArray.isNotEmpty() && sadArray.size > 2) {

            array.add(sadArray[0])
            val indexOfTheLastElement = sadArray.lastIndex
            var arraySize = array.size

            for (i in 1 until indexOfTheLastElement) {
                if (sadArray[i - 1] + sadArray[i + 1] > sadArray[i]) {
                    array.add(sadArray[i])
                    arraySize += 1
                }
                if (arraySize > 2
                    && array[arraySize - 3] + array.last() < array[arraySize - 2]
                ) {
                    array.removeAt(arraySize - 2)
                    arraySize -= 1
                }
            }
            array.add(sadArray.last())
            array.toIntArray()
        } else array.toIntArray()
    }
}
