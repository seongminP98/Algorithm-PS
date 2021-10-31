import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RoomNumber1475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        Map<Character, Integer> hm = new HashMap();
        int answer = 0;

        for (int i = 0; i < N.length(); i++) {
            char n = N.charAt(i);
            if (n == '6')
                n = '9';

            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        if (hm.containsKey('9')) {
            if (hm.get('9') % 2 == 0) {
                hm.put('9', hm.get('9') / 2);
            } else {
                hm.put('9', hm.get('9') / 2 + 1);
            }
        }

        for (Character character : hm.keySet()) {
            answer = Math.max(answer, hm.get(character));
        }
        System.out.println(answer);

    }
}
