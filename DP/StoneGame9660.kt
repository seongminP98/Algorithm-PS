fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toLong()
    if (N % 7 == 0L || N % 7 == 2L) {
        print("CY")
    } else {
        print("SK")
    }
}