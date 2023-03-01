class ZigzagConversion {
    private fun convert(s: String, numRows: Int): String {
        if(numRows == 1) return s
        val answer = StringBuilder()
        val c = (numRows - 1) * 2
        var jump1 = c
        var jump2 = 0
        for (i in 0..numRows - 2) {
            var idx = i
            var flag = true
            while (idx < s.length) {
                idx += if (flag) {
                    answer.append(s[idx])
                    jump1
                } else {
                    if (jump2 != 0) {
                        answer.append(s[idx])
                        jump2
                    } else {
                        0
                    }
                }
                flag = !flag
            }
            jump1 -= 2
            jump2 += 2
        }
        var j = numRows - 1
        while (j < s.length) {
            answer.append(s[j])
            j += c
        }
        return answer.toString()
    }
}

