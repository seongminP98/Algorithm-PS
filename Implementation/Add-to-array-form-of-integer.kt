private class Solution {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        val result = mutableListOf<Int>()
        var check = 0
        var numK = k
        for (i in num.size - 1 downTo 0) {
            var n = 0
            if (numK > 0) {
                n = numK % 10
                numK /= 10
            }
            val sum = num[i] + n + check
            check = if (sum >= 10) {
                1
            } else {
                0
            }
            result.add(sum % 10)
        }
        if (check == 1 && numK == 0) result.add(1)
        if (check == 1 && numK > 0) numK += 1

        while (numK > 0) {
            val n = numK % 10
            numK /= 10
            result.add(n)
        }
        return result.reversed()
    }
}