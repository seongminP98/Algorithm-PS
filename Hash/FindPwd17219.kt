import java.util.*
import kotlin.collections.HashMap

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()
    val map = HashMap<String, String>()
    while (N-- > 0) {
        st = StringTokenizer(readLine())
        map[st.nextToken()] = st.nextToken()
    }
    val answer = StringBuilder()
    while (M-- > 0) {
        answer.append(map.get(readLine())).append('\n')
    }
    print(answer)
}