package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        val array = bill.toMutableList()
        array.removeAt(k)
        val correctAnnaBill = array.sum() / 2

        var result = "Bon Appetit"

        return if (correctAnnaBill == b) {
            result
        } else {
            result = (b - correctAnnaBill).toString()
            result
        }
    }
}
