fun main() = with(System.`in`.bufferedReader()) {
    val arr = readLine().toCharArray()
    var answer = 0
    val duck = arrayOf('q', 'u', 'a', 'c', 'k')
    var idx = 0

    if (arr.size % 5 != 0) {
        print(-1)
        return
    }
    var cnt = 0
    var n = 506
    while (n-- > 0) {
        for (i in arr.indices) {
            if (arr[i] == duck[idx]) {
                cnt++
                idx = (idx + 1) % 5
                arr[i] = 'x'
            }
        }
        if (idx == 0) {
            answer++
        } else {
            print(-1)
            return
        }
        if (cnt == arr.size) break
    }
    if (cnt == arr.size) {
        print(answer)
    } else {
        print(-1)
    }
}