import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Gerrymandering17471 {
    static int N;
    static int[] population;
    static ArrayList<ArrayList<Integer>> list;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        powerSet(1, new boolean[N + 1]);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    static void powerSet(int idx, boolean[] visited) {
        if (idx == N + 1) {
            if (connectCheck(visited)) {
                solution(visited);
            }
            return;
        }
        visited[idx] = false;
        powerSet(idx + 1, visited);
        visited[idx] = true;
        powerSet(idx + 1, visited);
    }

    static void solution(boolean[] visited) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                sumA += population[i];
            } else {
                sumB += population[i];
            }
        }
        answer = Math.min(answer, Math.abs(sumA - sumB));
    }

    static boolean connectCheck(boolean[] visited) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                a.add(i);
            } else {
                b.add(i);
            }
        }

        if (a.size() == 0 || b.size() == 0) {
            return false;
        }
        if (!bfs(a)) return false;
        if (!bfs(b)) return false;

        return true;

    }

    static boolean bfs(List<Integer> a) {
        boolean[] visited = new boolean[N + 1];
        int start = a.get(0);
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int count = 1;
        while (!q.isEmpty()) {
            int c = q.poll();
            for (Integer i : list.get(c)) {
                if (!visited[i] && a.contains(i)) {
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        return count == a.size();
    }
}
