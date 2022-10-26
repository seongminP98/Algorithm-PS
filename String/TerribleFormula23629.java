import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TerribleFormula23629 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        map.put("ZERO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);
        map.put("FIVE", 5);
        map.put("SIX", 6);
        map.put("SEVEN", 7);
        map.put("EIGHT", 8);
        map.put("NINE", 9);

        boolean check = false;
        while (true) {
            boolean flag = false;
            for (String key : map.keySet()) {
                if (s.startsWith(key)) {
                    s = s.substring(key.length());
                    sb.append(map.get(key));
                    flag = true;
                    check = false;
                    break;
                }
            }
            if (!flag) {
                if (check) { // 기호 연속으로 오는경우
                    System.out.println("Madness!");
                    return;
                }
                check = true;
                sb.append(s.charAt(0));
                if (s.charAt(0) == '=') {
                    break;
                }
                s = s.substring(1);
            }
        }

        long sum = 0;
        long num = 0;
        long op = '.';
        System.out.println(sb);
        boolean first = false;
        for (int i = 0; i < sb.toString().length(); i++) {
            if (sb.toString().charAt(i) >= '0' && sb.toString().charAt(i) <= '9') {
                num *= 10;
                num += sb.toString().charAt(i) - '0';
            } else {
                if (!first) {
                    first = true;
                    sum = num;
                }
                if (op == '+') {
                    sum += num;
                } else if (op == '-') {
                    sum -= num;
                } else if (op == 'x') {
                    sum *= num;
                } else if (op == '/') {
                    sum /= num;
                }
                num = 0;
                op = sb.toString().charAt(i);
            }
        }
        StringBuilder answer = new StringBuilder();
        if (sum < 0) {
            answer.append('-');
            sum = Math.abs(sum);
        }
        String sumStr = Long.toString(sum);
        for (int i = 0; i < sumStr.length(); i++) {
            for (String key : map.keySet()) {
                if (sumStr.charAt(i) - '0' == map.get(key)) {
                    answer.append(key);
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
