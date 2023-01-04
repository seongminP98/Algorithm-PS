import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val G = readLine().toLong()
    var x = 2L
    var y = 1L
    val answer = StringBuilder()
    while (x < 100_000) {
        val sx = x * x
        val sy = y * y
        if (sx - sy == G) {
            answer.append(x).append('\n')
        }
        if (sx - sy > G) {
            y++
        } else {
            x++
        }
    }
    if(answer.isEmpty()) {
        print(-1)
    } else {
        print(answer)
    }
}