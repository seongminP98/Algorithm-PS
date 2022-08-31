import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartingList3980 {
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            answer = 0;
            arr = new int[11][11];
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solution(0, 0, new boolean[11]);
            System.out.println(answer);
        }
    }

    private static void solution(int sum, int depth, boolean[] visited) {
        if (depth == 11) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (arr[depth][i] == 0 || visited[i]) continue;

            visited[i] = true;
            solution(sum + arr[depth][i], depth + 1, visited);
            visited[i] = false;
        }
    }

}
