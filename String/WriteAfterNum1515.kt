fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine();
    var n = 0
    var idx = 0;
    while (true) {
        n++
        val tmp = n.toString()
        for (j in tmp.indices) {
            if (s[idx] == tmp[j]) {
                idx++
            }
            if (idx == s.length) {
                print(n)
                return;
            }
        }
    }
}