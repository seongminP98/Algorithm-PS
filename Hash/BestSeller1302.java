import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BestSeller1302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            hm.put(book, hm.getOrDefault(book, 0) + 1);
        }
        int max = 0;
        for (String s : hm.keySet()) {
            max = Math.max(max, hm.get(s));
        }

        List<String> list = new ArrayList<>(hm.keySet());
        Collections.sort(list);
        for (String s : list) {
            if (hm.get(s) == max) {
                System.out.println(s);
                break;
            }
        }
    }
}
