import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LCA11437 {
    static List<List<Integer>> list = new ArrayList<>();
    static Node[] node;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        node = new Node[N + 1];
        node[1] = new Node(0, 0);

        dfs(1, 1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (node[a].h > node[b].h) {
                int diff = node[a].h - node[b].h;
                while (diff-- > 0) {
                    a = node[a].parent;
                }
            } else {
                int diff = node[b].h - node[a].h;
                while (diff-- > 0) {
                    b = node[b].parent;
                }
            }

            while (a != b) {
                a = node[a].parent;
                b = node[b].parent;
            }
            sb.append(a).append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int c, int depth) {
        for (Integer child : list.get(c)) {
            if (node[child] == null) {
                node[child] = new Node(depth, c);
                dfs(child, depth + 1);
            }
        }
    }

    private static class Node {
        int h, parent;

        public Node(int h, int parent) {
            this.h = h;
            this.parent = parent;
        }
    }
}
