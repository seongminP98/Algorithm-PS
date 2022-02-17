import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runway14890 {
    static int N, L;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) { //행
            int prev = arr[i][0];
            boolean[] flag = new boolean[N];
            boolean check = true;
            loop:
            for (int j = 0; j < N; j++) {
                if (prev == arr[i][j]) {
                    continue;
                } else if (prev > arr[i][j]) {
                    for (int k = 0; k < L; k++) {
                        if (j + k < N && arr[i][j + k] == prev - 1 && !flag[j + k]) {
                            flag[j + k] = true;
                        } else {
                            check = false;
                            break loop;
                        }
                    }
                    j += L - 1;
                } else { //prev < arr[i][j]
                    for (int k = 1; k <= L; k++) {
                        if (j - k >= 0 && arr[i][j - k] == arr[i][j] - 1 && !flag[j - k]) {
                            flag[j - k] = true;
                        } else {
                            check = false;
                            break loop;
                        }
                    }
                }
                prev = arr[i][j];
            }
            if (check) {
                answer++;
            }
        }

        for (int j = 0; j < N; j++) { //열
            int prev = arr[0][j];
            boolean[] flag = new boolean[N];
            boolean check = true;
            loop:
            for (int i = 0; i < N; i++) {
                if (prev == arr[i][j]) {
                    continue;
                } else if (prev > arr[i][j]) {
                    for (int k = 0; k < L; k++) {
                        if (i + k < N && arr[i + k][j] == prev - 1 && !flag[i + k]) {
                            flag[i + k] = true;
                        } else {
                            check = false;
                            break loop;
                        }
                    }
                    i += L - 1;
                } else {
                    for (int k = 1; k <= L; k++) {
                        if (i - k >= 0 && arr[i - k][j] == arr[i][j] - 1 && !flag[i - k]) {
                            flag[i - k] = true;
                        } else {
                            check = false;
                            break loop;
                        }
                    }
                }
                prev = arr[i][j];
            }
            if (check) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
