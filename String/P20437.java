import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P20437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < W.length(); i++) {
                list.get(W.charAt(i) - 'a').add(i);
            }
            int min = 10000;
            int max = 0;
            for (List<Integer> chars : list) {
                if (chars.size() < K) continue;

                for (int i = 0; i <= chars.size() - K; i++) {
                    min = Math.min(min, chars.get(i + K - 1) - chars.get(i) + 1);
                    max = Math.max(max, chars.get(i + K - 1) - chars.get(i) + 1);
                }
            }
            if (max == 0) {
                sb.append(-1);
            } else {
                sb.append(min).append(" ").append(max);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
