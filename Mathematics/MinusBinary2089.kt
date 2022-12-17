fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    if (N == 0) {
        print(0)
        return
    }
    val sb = StringBuilder()
    while (N != 1) {
        sb.append(Math.abs(N % -2))
        N = Math.ceil(N.toDouble() / -2).toInt()
    }
    sb.append(N)
    print(sb.reverse())
}