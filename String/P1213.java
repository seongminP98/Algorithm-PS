import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int oddCheck = 0;
        char odd = 0;
        Map<Character, Integer> map = new TreeMap<>(); //정답이 여러개면 사전순 출력. HashMap 사용하면 틀림.
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }


        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                oddCheck++;
                odd = key;
            }
        }

        StringBuilder answer = new StringBuilder();
        if (oddCheck > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (Character key : map.keySet()) {

                if (map.get(key) > 1) {
                    int n = map.get(key) / 2;
                    answer.append(String.valueOf(key).repeat(Math.max(0, n)));
                    /*for (int i = 0; i < n; i++) {
                        answer.append(key);
                    }*/
                }
            }
            String reverse = answer.toString();
            if (oddCheck == 1) {
                answer.append(odd);
            }

            for (int i = reverse.length() - 1; i >= 0; i--) {
                answer.append(reverse.charAt(i));
            }
            System.out.println(answer);
        }
    }
}
