import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FuelFill1826 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Gas[] gas = new Gas[N];
        PriorityQueue<Gas> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gas[i] = new Gas(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken()); // 시작위치에서 마을까지 거리
        int P = Integer.parseInt(st.nextToken()); // 현재 연료 양
        int answer = 0;
        Arrays.sort(gas, new Comparator<Gas>() {
            @Override
            public int compare(Gas o1, Gas o2) {
                return Integer.compare(o1.a, o2.a);
            }
        });
        int idx = 0;
        while (true) {
            if (P >= L) {
                break;
            }
            if (!pq.isEmpty()) {
                P += pq.poll().b;
                answer++;
            }

            for (int i = idx; i < N; i++) {
                if (gas[i].a >= L) continue;
                if (gas[i].a <= P) {
                    pq.add(gas[i]);
                } else {
                    idx = i;
                    break;
                }
            }
            if(pq.isEmpty()) {
                break;
            }
        }
        if (P >= L) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static class Gas implements Comparable<Gas> {
        int a, b; // a : 시작위치에서 주유소까지 거리, b : 그 주유소의 연료 양

        public Gas(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Gas o) {
            return Integer.compare(o.b, b);
        }
    }
}
