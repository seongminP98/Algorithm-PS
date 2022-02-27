import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PowerShortage6497 {
    static int N, M;
    static List<Edge> list;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            M = Integer.parseInt(st.nextToken()); //집의 수
            N = Integer.parseInt(st.nextToken()); //길의 수
            list = new ArrayList<>();
            parent = new int[M];
            for (int i = 0; i < M; i++) {
                parent[i] = i;
            }
            int sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                sum += z;
                list.add(new Edge(x, y, z));
            }
            Collections.sort(list);
            for (int i = 0; i < N; i++) {
                if (!isSameParent(list.get(i).x, list.get(i).y)) {
                    sum -= list.get(i).z;
                    union(list.get(i).x, list.get(i).y);
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
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

    static class Edge implements Comparable<Edge> {
        int x, y, z;

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Edge o) {
            return z - o.z;
        }
    }
}
