import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StatureOrder2458 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> list;
    static ArrayList<ArrayList<Integer>> listReverse;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        listReverse = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            listReverse.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            listReverse.get(e).add(s);
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            if (check(i, list, visited)) {
                answer++;
                continue;
            }
            if (check(i, listReverse, visited)) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    static boolean check(int n, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[0] = visited[n] = true;
        q.add(n);
        while (!q.isEmpty()) {
            int c = q.poll();
            for (Integer next : list.get(c)) {
                if (visited[next]) continue;

                visited[next] = true;
                q.add(next);
            }
        }
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }
}
