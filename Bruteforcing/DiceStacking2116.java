import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceStacking2116 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < 6; i++) {
            answer = Math.max(answer, solution(arr, i));
        }
        System.out.println(answer);
    }

    private static int solution(int[][] arr, int idx) {
        //0,5 / 1,3 / 2,4
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean[] check = new boolean[7];
            if (idx == 0) {
                check[arr[i][0]] = true;
                check[arr[i][5]] = true;
                for (int j = 0; j < 6; j++) {
                    if (arr[i][5] == arr[i + 1][j]) {
                        idx = j;
                    }
                }
            } else if (idx == 1) {
                check[arr[i][1]] = true;
                check[arr[i][3]] = true;
                for (int j = 0; j < 6; j++) {
                    if (arr[i][3] == arr[i + 1][j]) {
                        idx = j;
                    }
                }
            } else if (idx == 2) {
                check[arr[i][2]] = true;
                check[arr[i][4]] = true;
                for (int j = 0; j < 6; j++) {
                    if (arr[i][4] == arr[i + 1][j]) {
                        idx = j;
                    }
                }
            } else if (idx == 3) {
                check[arr[i][1]] = true;
                check[arr[i][3]] = true;
                for (int j = 0; j < 6; j++) {
                    if (arr[i][1] == arr[i + 1][j]) {
                        idx = j;
                    }
                }
            } else if (idx == 4) {
                check[arr[i][2]] = true;
                check[arr[i][4]] = true;
                for (int j = 0; j < 6; j++) {
                    if (arr[i][2] == arr[i + 1][j]) {
                        idx = j;
                    }
                }
            } else if (idx == 5) {
                check[arr[i][0]] = true;
                check[arr[i][5]] = true;
                for (int j = 0; j < 6; j++) {
                    if (arr[i][0] == arr[i + 1][j]) {
                        idx = j;
                    }
                }
            }
            for (int j = 6; j >= 0; j--) {
                if (!check[j]) {
                    sum += j;
                    break;
                }
            }
        }
        return sum;
    }
}
