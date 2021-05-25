package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val array = mutableListOf<Int>()

        return if (sadArray.isNotEmpty() && sadArray.size > 2) {

            array.add(sadArray[0])
            val indexOfTheLastElement = sadArray.size - 1

            for (i in 1 until indexOfTheLastElement) {
                if (sadArray[i - 1] + sadArray[i + 1] > sadArray[i])
                    array.add(sadArray[i])
                var t = array.size
                if (t > 2 && array[t - 3] + array[t - 1] < array[t - 2]) {
                    array.removeAt(t - 2)
                }
            }
            array.add(sadArray[indexOfTheLastElement])
            array.toIntArray()
        } else array.toIntArray()
    }
}
