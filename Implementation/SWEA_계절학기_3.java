import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_계절학기_3 {
    static int F, N;
    static Queue<Integer> q;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            F = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                q.add(next);
                map.put(next, map.getOrDefault(next, 0) + 1);
            }
            sb.append(game()).append('\n');
        }
        System.out.print(sb);
    }

    private static int game() {
        while (true) { // 턴
//            System.out.println("turn");
            int turnSize = q.size();
            if (q.size() == 1 || F == 1) {
                return q.poll();
            }
            int max = 0;
            for (Integer value : map.values()) {
                max = Math.max(max, value);
            }
            List<Integer> maxList = new ArrayList<>();
            for (Integer key : map.keySet()) {
                if (map.get(key) == max) {
                    maxList.add(key);
                }
            }
            boolean flag = false;
            while (turnSize-- > 0) {

                if (q.size() == 1 || F == 1) {
                    return q.poll();
                }
//                System.out.println("q.peek() = " + q.peek() + " F = " + F + " qsize = " + q.size());
                if (!flag && maxList.contains(q.peek())) {
                    map.put(q.peek(), map.get(q.peek()) - 1);
                    q.poll();
                    flag = true;
                } else {
                    q.add(q.poll());
                }
                F--;
            }
        }

    }
}
