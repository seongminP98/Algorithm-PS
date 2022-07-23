import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sum1132 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Alpha[] arr = new Alpha[10];
        boolean[] notZero = new boolean[10]; // 0이면 안되는 알파벳
        String[] str = new String[N]; // 문자 저장
        for (int i = 0; i < 10; i++) {
            arr[i] = new Alpha();
        }
        while (N-- > 0) {
            String s = br.readLine();
            str[N] = s;
            int len = s.length();
            notZero[s.charAt(0) - 'A'] = true; // 수의 첫자리는 0이면 안됨.

            for (int i = 0; i < len; i++) {
                Alpha alpha = arr[s.charAt(i) - 'A'];
                alpha.score += Math.pow(10, len - i);
                alpha.cnt++;
                alpha.index = s.charAt(i) - 'A';
            }
        }
        Arrays.sort(arr);
        boolean existZero = true;
        for (int i = 0; i < 10; i++) {
            if (arr[i].cnt == 0) {
                existZero = false;
                break;
            }
        }
        int canZero = 9;
        for (int i = 9; i >= 0; i--) {
            if (notZero[arr[i].index]) { // 0안됨
                canZero--;
            } else {
                break;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int num = 9;
        for (Alpha alpha : arr) {
            if (alpha.cnt == 0) continue;
            if (existZero && alpha.index == arr[canZero].index) {
                map.put(alpha.index, 0);
            } else {
                map.put(alpha.index, num--);
            }
        }

        long answer = 0;
        for (String s : str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(map.get(s.charAt(i) - 'A'));
            }
            answer += Long.parseLong(sb.toString());
        }
        System.out.println(answer);
    }

    private static class Alpha implements Comparable<Alpha> {
        int cnt, index;
        long score;

        @Override
        public String toString() {
            return "Alpha{" +
                    "cnt=" + cnt +
                    ", score=" + score +
                    ", index=" + index +
                    '}';
        }

        public Alpha() {
        }

        @Override
        public int compareTo(Alpha o) {
            return Long.compare(o.score, this.score);
        }
    }
}
