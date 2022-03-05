import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//크루스칼 사용. 프림으로 하면 더 빠를듯.
public class WateringTheFields10021 {
    static int N, C;
    static int[][] arr;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++) { //모든 가중치 다 구함.
            for (int j = i + 1; j < N; j++) {
                int cost = (int) Math.pow(arr[i][0] - arr[j][0], 2) + (int) Math.pow(arr[i][1] - arr[j][1], 2);
                if (cost < C) { //이거 추가안하면 시간이 많이 걸림.
                    continue;
                }
                pq.add(new Node(i, j, cost));
            }
        }
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int answer = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.cost >= C && !isSameParent(current.start, current.end)) {
                union(current.start, current.end);
                answer += current.cost;
                count++;
            }
            if (count == N - 1) //MST 의 간선은 N-1개
                break;
        }
        if (count != N - 1) {
            System.out.println(-1);

        } else {
            System.out.println(answer);

        }
    }

    static int findParent(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }

    static boolean isSameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    static class Node implements Comparable<Node> {
        int start, end, cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
