import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameOfDeath17204 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int target = 0;
        int count = 0;
        boolean flag = false;
        boolean[] visited = new boolean[N];
        while (true) {
            if (arr[target] == K) {
                count++;
                break;
            }
            if (visited[arr[target]]) {
                flag = true;
                break;
            } else {
                target = arr[target];
                visited[target] = true;
                count++;
            }
        }
        if (flag)
            System.out.println(-1);
        else
            System.out.println(count);
    }
}
