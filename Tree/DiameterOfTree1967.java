import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DiameterOfTree1967 {
    static int N;
    static boolean[] isParent; // false면 리프노드
    static List<List<Tree>> list;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        isParent = new boolean[N + 1];
        int rootCheck = 0;
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (p == 1) rootCheck++;
            isParent[p] = true;
            list.get(p).add(new Tree(c, w));
            list.get(c).add(new Tree(p, w));
        }
        if (rootCheck == 1) {
            isParent[1] = false;
        }

        for (int i = 1; i <= N; i++) {
            if (isParent[i]) continue;
            boolean[] visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, visited, 0);

        }
        System.out.println(answer);
    }

    private static void dfs(int c, boolean[] visited, int sum) {
        for (Tree tree : list.get(c)) {
            if (visited[tree.node]) continue;
            visited[tree.node] = true;

            if (!isParent[tree.node]) {
                answer = Math.max(answer, sum + tree.weight);
                visited[tree.node] = true;
            }
            dfs(tree.node, visited, sum + tree.weight);
        }
    }


    private static class Tree {
        int node, weight;

        public Tree(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
