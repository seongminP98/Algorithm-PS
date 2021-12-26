import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BlackJack2798 {
    static int N, M;
    static boolean[] visited;
    static int answer = 0;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n < M) {
                list.add(n);
            }
        }
        visited = new boolean[N];
        combination(0, 0, 0);
        System.out.println(answer);

    }

    static void combination(int start, int depth, int sum) {
        if (depth == 3 && sum <= M) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            if (sum + list.get(i) > M) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, depth + 1, sum + list.get(i));
            }
            visited[i] = false;
        }
    }
}
