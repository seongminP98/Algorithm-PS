import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val S = readLine()
    val dq = ArrayDeque<Char>()
    var zeroCnt = 0
    var oneCount = 0
    for (c in S) {
        if (c == '1') oneCount++ else zeroCnt++
        dq.addLast(c)
    }
    oneCount /= 2
    zeroCnt /= 2
    var oneAdd = 0
    while (zeroCnt > 0) {
        if (dq.last() == '0') {
            zeroCnt--;
        } else {
            oneAdd++;
        }
        dq.removeLast()
    }
    while (oneAdd-- > 0) {
        dq.addLast('1')
    }
    var zeroAdd = 0
    while (oneCount > 0) {
        if (dq.first() == '1') {
            oneCount--;
        } else {
            zeroAdd++;
        }
        dq.removeFirst()
    }
    while (zeroAdd-- > 0) {
        dq.addFirst('0')
    }

    val answer = StringBuilder()
    for (c in dq) {
        answer.append(c)
    }
    print(answer)
}