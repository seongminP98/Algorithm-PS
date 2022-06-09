import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodSequence2661 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            solve(N, 1, sb);
        }
    }

    private static void solve(int N, int depth, StringBuilder sb) {
        if (depth == N) {
            System.out.println(sb);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (sb.charAt(depth - 1) - '0' == i) continue;
            sb.append(i);
            if (check(sb.length(), sb)) {
                solve(N, depth + 1, sb);
            }
            sb.deleteCharAt(sb.length() - 1);

        }
    }

    private static boolean check(int len, StringBuilder sb) {
        for (int i = 2; i <= len / 2; i++) {
            String after = sb.substring(len - i, len);
            String before = sb.substring(len - 2 * i, len - i);
            if (after.equals(before)) {
                return false;
            }
        }
        return true;
    }
}
