import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Rumor19538 {
    static int N, M;
    static List<List<Integer>> list; // 주변인
    static int[] answer;
    static int[] turn;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) break;
                list.get(i).add(num);
            }
        }

        M = Integer.parseInt(br.readLine());
        answer = new int[N + 1];
        turn = new int[N + 1];
        Arrays.fill(answer, -1);
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            answer[num] = 0;
            q.add(num);
        }
        for (int i = 1; i <= N; i++) {
            turn[i] = (list.get(i).size() + 1) / 2;
        }

        bfs(q);
        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static void bfs(Queue<Integer> q) {
        while (!q.isEmpty()) {
            int c = q.poll();
            for (Integer next : list.get(c)) { // 루머 유포
                turn[next]--;
                if (answer[next] == -1 && turn[next] <= 0) {
                    q.add(next);
                    answer[next] = answer[c] + 1;
                }
            }
        }
    }
}
