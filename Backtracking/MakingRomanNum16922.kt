var check = Array(1001) { false }
var arr = arrayOf(1, 5, 10, 50)
fun main() = with(System.`in`.bufferedReader()) {
    combination(0, readLine().toInt(), 0, 0);
    var answer = 0
    for (b in check) {
        if (b) answer++;
    }
    print(answer)
}

fun combination(depth: Int, N: Int, sum: Int, start: Int) {
    if (depth == N) {
        check[sum] = true;
        return;
    }
    for (i in start..3) {
        combination(depth + 1, N, sum + arr[i], i);
    }
}