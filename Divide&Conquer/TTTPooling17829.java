import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TTTPooling17829 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(N);
        System.out.println(arr[0][0]);

    }

    static void solution(int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < n; j += 2) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i][j]);
                list.add(arr[i + 1][j]);
                list.add(arr[i][j + 1]);
                list.add(arr[i + 1][j + 1]);
                Collections.sort(list);
                arr[i / 2][j / 2] = list.get(2);
            }
        }
        solution(n / 2);
    }
}
