import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CreateConstellations4386 {
    static int N;
    static Node[] arr;
    static List<Edge> list = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double cost = getDistance(arr[i], arr[j]);
                list.add(new Edge(i, j, cost));
            }
        }
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        list.sort(((o1, o2) -> {
            if (o1.cost > o2.cost) {
                return 1;
            } else if (o1.cost == o2.cost) {
                return 0;
            }
            return -1;
        }));
        double answer = 0;
        for (Edge edge : list) {
            if (!isSameParent(edge.s, edge.e)) {
                union(edge.s, edge.e);
                answer += edge.cost;
            }
        }
        answer = Math.round(answer * 100) / 100.0;
        System.out.print(answer);
    }

    //union
    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    //findParent
    static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    //isSameParent
    static boolean isSameParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        return x == y;
    }


    static double getDistance(Node n1, Node n2) {
        return Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
    }

    static class Node {
        double x, y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int s, e;
        double cost;

        public Edge(int s, int e, double cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "s=" + s +
                    ", e=" + e +
                    ", cost=" + cost +
                    '}';
        }
    }
}
