import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GerrymanderingT17779 {
    static int N;
    static int[][] arr;
    static int total = 0;
    static int answer = 40000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
            }
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 > N || y - d1 < 1 || y >= y + d2 || y + d2 > N) continue;
                        solution(x, y, d1, d2);

                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void solution(int x, int y, int d1, int d2) {
        boolean[][] check = new boolean[N + 1][N + 1]; // 경계선

        for (int i = 0; i <= d1; i++) {
            check[x + i][y - i] = true;
            check[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            check[x + i][y + i] = true;
            check[x + d1 + i][y - d1 + i] = true;
        }

        int[] population = new int[5];

        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (check[i][j]) break; // 경계선 만나면 줄바꿈
                population[0] += arr[i][j];
            }
        }
        for (int i = 1; i <= x + d2; i++) {
            for (int j = N; j > y; j--) {
                if (check[i][j]) break;
                population[1] += arr[i][j];
            }
        }
        for (int i = x + d1; i <= N; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (check[i][j]) break;
                population[2] += arr[i][j];
            }
        }
        for (int i = x + d2 + 1; i <= N; i++) {
            for (int j = N; j >= y - d1 + d2; j--) {
                if (check[i][j]) break;
                population[3] += arr[i][j];
            }
        }
        population[4] = total - (population[0] + population[1] + population[2] + population[3]);
        Arrays.sort(population);
        answer = Math.min(answer, population[4] - population[0]);
    }
}
