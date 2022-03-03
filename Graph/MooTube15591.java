import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MooTube15591 {
    static int N, Q;
    static List<ArrayList<Relation>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.get(p).add(new Relation(q, r));
            list.get(q).add(new Relation(p, r));
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < Q; t++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int video = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            q.add(video);
            boolean[] visited = new boolean[N + 1];
            visited[video] = true;
            int count = 0;
            while (!q.isEmpty()) {
                int c = q.poll();
                for (Relation relation : list.get(c)) {
                    if (!visited[relation.q] && relation.r >= K) {
                        visited[relation.q] = true;
                        q.add(relation.q);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    static class Relation {
        int q, r;

        public Relation(int q, int r) {
            this.q = q;
            this.r = r;
        }
    }
}
