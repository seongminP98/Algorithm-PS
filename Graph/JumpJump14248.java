import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpJump14248 {
    static int n;
    static int[] arr;
    static int start;
    static boolean[] visited;
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        start = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        visited[start] = true;
        dfs(start);
        System.out.println(answer);
    }

    static void dfs(int x) {
        if (x + arr[x] <= n && !visited[x + arr[x]]) {
            visited[x + arr[x]] = true;
            answer++;
            dfs(x + arr[x]);
        }
        if (x - arr[x] >= 1 && !visited[x - arr[x]]) {
            visited[x - arr[x]] = true;
            answer++;
            dfs(x - arr[x]);
        }
    }
}
