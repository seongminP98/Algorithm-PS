import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val k = readLine().toInt()
    val dp: Array<Array<Int>> = Array(k + 1) { Array(t + 1) { 0 } }
    val list = mutableListOf<Coin>()
    for (i in 0 until k) {
        val st = StringTokenizer(readLine())
        list.add(Coin(st.nextToken().toInt(), st.nextToken().toInt()))
    }
    list.sort()
    for (i in 0..k) {
        dp[i][0] = 1 // 0 원의 경우는 1개
    }
    for (i in 1..k) {
        val cost = list[i - 1].cost
        val num = list[i - 1].num
        for (j in 1..t) { // 돈
            for (p in 0..num) {
                if (j - (cost * p) < 0) break
                dp[i][j] += dp[i - 1][j - (cost * p)]

            }
        }
    }
    print(dp[k][t])
}

data class Coin(val cost: Int, val num: Int) : Comparable<Coin> {
    override fun compareTo(other: Coin): Int {
        return compareValues(this.cost, other.cost)
    }
}