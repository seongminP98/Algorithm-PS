import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoThousandFortyEightE12100 {
    static int N;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0}; // 아래 위 오른쪽 왼쪽
    static int[] dy = {0, 0, 1, -1};
    static int[] d = {1, -1, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);
        System.out.println(answer);
    }

    static void solve(int depth) {
        if (depth == 5) {
            answer = Math.max(answer, getMax());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] temp = new int[N][N];
            for (int x = 0; x < N; x++) {
                System.arraycopy(arr[x], 0, temp[x], 0, N);
            }
//            System.out.println("depth = " + depth);
            game(i);
            solve(depth + 1);
            for (int x = 0; x < N; x++) {
                System.arraycopy(temp[x], 0, arr[x], 0, N);
            }
        }
    }

    static void game(int dir) {
        /*
        0 : 아래에서 위로
        1 : 위에서 아래로
        2 : 오른쪽에서 왼쪽으로
        3 : 왼쪽에서 오른쪽으로
         */
        int[] idx = new int[N];
        if (dir == 0) {
            for (int i = 0; i < N; i++) {
                next:
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0) continue;
                    int val = arr[i][j];
                    for (int k = i + 1; k < N; k++) {
                        if (arr[k][j] != 0 && arr[k][j] != arr[i][j]) {
                            arr[i][j] = 0;
                            arr[idx[j]++][j] = val;
                            continue next;
                        } else if (arr[k][j] == arr[i][j]) { // 합쳐질 때
                            arr[k][j] = 0;
                            arr[i][j] = 0;
                            arr[idx[j]++][j] = val * 2;
                            continue next;
                        }
                    }
                    arr[i][j] = 0;
                    arr[idx[j]++][j] = val;
                }
            }
        } else if (dir == 1) {
            Arrays.fill(idx, N - 1);
            for (int i = N - 1; i >= 0; i--) {
                next:
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0) continue;
                    int val = arr[i][j];
                    for (int k = i - 1; k >= 0; k--) {
                        if (arr[k][j] != 0 && arr[k][j] != arr[i][j]) {
                            arr[i][j] = 0;
                            arr[idx[j]--][j] = val;
                            continue next;
                        } else if (arr[k][j] == arr[i][j]) { // 합쳐질 때
                            arr[k][j] = 0;
                            arr[i][j] = 0;
                            arr[idx[j]--][j] = val * 2;
                            continue next;
                        }
                    }
                    arr[i][j] = 0;
                    arr[idx[j]--][j] = val;
                }
            }
        } else if (dir == 2) {
            for (int j = 0; j < N; j++) {
                next:
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 0) continue;
                    int val = arr[i][j];
                    for (int k = j + 1; k < N; k++) {
                        if (arr[i][k] != 0 && arr[i][k] != arr[i][j]) {
                            arr[i][j] = 0;
                            arr[i][idx[i]++] = val;
                            continue next;
                        } else if (arr[i][k] == arr[i][j]) { // 합쳐질 때
                            arr[i][k] = 0;
                            arr[i][j] = 0;
                            arr[i][idx[i]++] = val * 2;
                            continue next;
                        }
                    }
                    arr[i][j] = 0;
                    arr[i][idx[i]++] = val;
                }
            }
        } else if (dir == 3) {
            Arrays.fill(idx, N - 1);
            for (int j = N - 1; j >= 0; j--) {
                next:
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 0) continue;
                    int val = arr[i][j];
                    for (int k = j - 1; k >= 0; k--) {
                        if (arr[i][k] != 0 && arr[i][k] != arr[i][j]) {
                            arr[i][j] = 0;
                            arr[i][idx[i]--] = val;
                            continue next;
                        } else if (arr[i][k] == arr[i][j]) { // 합쳐질 때
                            arr[i][k] = 0;
                            arr[i][j] = 0;
                            arr[i][idx[i]--] = val * 2;
                            continue next;
                        }
                    }
                    arr[i][j] = 0;
                    arr[i][idx[i]--] = val;
                }
            }
        }
//        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

    }

    static int getMax() {
        int max = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        return max;
    }
}
