import java.util.Arrays;

public class Move110 {
    public static void main(String[] args) {
        String[] s = {"1100111011101001"};
        System.out.println(Arrays.toString(solution(s)));
    }

    private static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        int idx = 0;
        for (String str : s) {
            StringBuilder sb = new StringBuilder();
            int num = 0;

            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                if (sb.length() >= 3 && sb.charAt(sb.length() - 1) == '0' & sb.charAt(sb.length() - 2) == '1' && sb.charAt(sb.length() - 3) == '1') {
                    num++;
                    sb.delete(sb.length() - 3, sb.length());
                }
            }
            if (num > 0) {
                if (sb.indexOf("0") == -1) {
                    sb.insert(0, "110".repeat(num));
                } else {
                    sb.insert(sb.lastIndexOf("0") + 1, "110".repeat(num));
                }
            }
            answer[idx++] = sb.toString();
        }
        return answer;
    }
}
