import java.util.StringTokenizer
import kotlin.math.abs

private var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    val mPlus = mutableListOf<Int>()
    val mMinus = mutableListOf<Int>()
    val wPlus = mutableListOf<Int>()
    val wMinus = mutableListOf<Int>()
    var st = StringTokenizer(readLine())
    for (i in 0 until n) {
        val h = st.nextToken().toInt()
        if (h > 0) {
            mPlus.add(h)
        } else {
            mMinus.add(abs(h))
        }
    }

    st = StringTokenizer(readLine())
    for (i in 0 until n) {
        val h = st.nextToken().toInt()
        if (h > 0) {
            wPlus.add(h)
        } else {
            wMinus.add(abs(h))
        }
    }

    mPlus.sort()
    wPlus.sort()
    mMinus.sort()
    wMinus.sort()

    print(solution(mMinus, wPlus) + solution(wMinus, mPlus))
}

fun solution(minusList: List<Int>, plusList: List<Int>): Int {
    var mIdx = 0
    var pIdx = 0
    var answer = 0
    while (mIdx < minusList.size && pIdx < plusList.size) {
        if (minusList[mIdx] > plusList[pIdx]) {
            mIdx++; pIdx++; answer++
        } else {
            pIdx++
        }
    }
    return answer
}
