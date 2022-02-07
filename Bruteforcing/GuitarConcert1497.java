import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarConcert1497 {
    static int N, M;
    static String[] arr;
    static boolean[] visited;
    static int maxSong = 0;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            arr[i] = st.nextToken();
        }
        visited = new boolean[N];
        powerSet(0);
        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void powerSet(int idx) {
        if (idx == N) {
            boolean[] check = new boolean[M];
            int result = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    result++;
                    for (int j = 0; j < M; j++) {
                        if (arr[i].charAt(j) == 'Y') {
                            check[j] = true;
                        }
                    }
                }
            }
            int maxCheck = 0;
            for (boolean b : check) {
                if (b)
                    maxCheck++;
            }
            if (maxSong < maxCheck) {
                answer = result;
                maxSong = maxCheck;
            } else if (maxSong == maxCheck) {
                answer = Math.min(answer, result);
            }
            return;
        }
        visited[idx] = false;
        powerSet(idx + 1);

        visited[idx] = true;
        powerSet(idx + 1);
    }
}
