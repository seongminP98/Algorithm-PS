import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class InformationMerchantHS22252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (query == 1) {
                for (int j = 0; j < num; j++) {
                    if (!map.containsKey(name)) {
                        map.put(name, new PriorityQueue<>((o1, o2) -> o2 - o1));
                    }
                    map.get(name).add(Integer.parseInt(st.nextToken()));
                }
            } else {
                for (int j = 0; j < num; j++) {
                    if (map.containsKey(name) && !map.get(name).isEmpty()) {
                        answer += map.get(name).poll();
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
