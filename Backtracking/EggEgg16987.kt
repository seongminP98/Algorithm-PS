import java.util.StringTokenizer

private var n = 0
private var answer = 0
private val eggs = mutableListOf<Egg>()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        eggs.add(Egg(st.nextToken().toInt(), st.nextToken().toInt()))
    }
    solve(0, 0)
    print(answer)
}

private fun solve(c: Int, cnt: Int) {
    if (c == n) {
        answer = answer.coerceAtLeast(cnt)
        return
    }
    if (eggs[c].s <= 0 || cnt == n - 1) {
        solve(c + 1, cnt)
        return
    }
    var count = cnt
    for (i in 0 until n) {
        if (i == c) continue
        if (eggs[i].s > 0) {
            eggs[i].s -= eggs[c].w
            eggs[c].s -= eggs[i].w

            if (eggs[i].s <= 0) {
                count++
            }
            if (eggs[c].s <= 0) {
                count++
            }
            solve(c + 1, count)
            eggs[i].s += eggs[c].w
            eggs[c].s += eggs[i].w
            count = cnt
        }
    }
}

data class Egg(var s: Int, var w: Int)
