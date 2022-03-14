import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TdArraysAndOperations17140 {
    static int[][] arr;
    static int r, c, k, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[101][101];
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        int row = 3;
        int column = 3;
        while (arr[r][c] != k && answer <= 100) {
            answer++;
            if (row >= column) {
                column = operationR();
            } else {
                row = operationC();
            }
        }

        if (answer == 101) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static int operationR() {
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= 100; j++) {
                if (arr[i][j] == 0)
                    continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);

            }
            PriorityQueue<Number> pq = new PriorityQueue<>();
            for (Integer key : map.keySet()) {
                pq.add(new Number(key, map.get(key)));
            }
            max = Math.max(max, pq.size() * 2);
            int idx = 1;
            while (!pq.isEmpty()) {
                arr[i][idx++] = pq.peek().num;
                arr[i][idx++] = pq.poll().cnt;
            }
            while (idx <= 100) {
                arr[i][idx++] = 0;
            }
        }
        return max;
    }

    static int operationC() {
        int max = 0;
        for (int j = 1; j <= 100; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= 100; i++) {
                if (arr[i][j] == 0)
                    continue;
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }
            PriorityQueue<Number> pq = new PriorityQueue<>();
            for (Integer key : map.keySet()) {
                pq.add(new Number(key, map.get(key)));
            }
            max = Math.max(max, pq.size() * 2);

            int idx = 1;
            while (!pq.isEmpty()) {
                arr[idx++][j] = pq.peek().num;
                arr[idx++][j] = pq.poll().cnt;
            }
            while (idx <= 100) {
                arr[idx++][j] = 0;
            }

        }
        return max;
    }

    static class Number implements Comparable<Number> {
        int num, cnt;

        public Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "num=" + num +
                    ", cnt=" + cnt +
                    '}';
        }

        @Override
        public int compareTo(Number o) {
            if (o == null) {
                return 1;
            }
            if (cnt == o.cnt) {
                return num - o.num;
            }
            return cnt - o.cnt;
        }
    }
}
