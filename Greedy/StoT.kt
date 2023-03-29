package P3806

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var case = 1
    repeat(readLine().toInt()) {
        val s = readLine()
        val t = readLine()
        var zero = 0
        var one = 0
        var unZero = 0
        var unOne = 0
        for (i in s.indices) {
            if (t[i] == '0' && s[i] == '1') {
                zero++
            } else if (t[i] == '1' && s[i] == '0') {
                one++;
            } else if (s[i] == '?') {
                if (t[i] == '0') {
                    unZero++
                } else {
                    unOne++
                }
            }
        }
        var ans = unOne + unZero
        if (zero <= one) {
            ans += zero
            one -= zero
            zero = 0
            ans += one
        } else {
            ans += one
            zero -= one
        }

        if (zero <= unOne) {
            ans += zero
            zero = 0
        }
        if (zero > 0) ans = -1
        sb.append("Case ${case++}: ").append(ans).append('\n')
    }
    print(sb)
}
