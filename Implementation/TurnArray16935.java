import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class TurnArray16935 {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            int r = Integer.parseInt(st.nextToken());
            if(!q.isEmpty()) {
                if(q.peekLast() == 1 && r == 1) {
                    q.pollLast();
                } else if(q.peekLast() == 2 && r == 2) {
                    q.pollLast();
                } else if(q.peekLast() == 3 && r == 4) {
                    q.pollLast();
                } else if(q.peekLast() == 4 && r == 3) {
                    q.pollLast();
                } else if(q.peekLast() == 5 && r == 6) {
                    q.pollLast();
                } else if(q.peekLast() == 6 && r == 5) {
                    q.pollLast();
                } else {
                    q.offerLast(r);
                }
            } else {
                q.offerLast(r);
            }
        }

        while(!q.isEmpty()) {
            int r = q.pollFirst();
            switch (r) {
                case 1:
                    arr = cal1();
                    break;
                case 2:
                    arr = cal2();
                    break;
                case 3:
                    arr = cal3();
                    break;
                case 4:
                    arr = cal4();
                    break;
                case 5:
                    arr = cal5();
                    break;
                case 6:
                    arr = cal6();
                    break;
                default:
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

    static int[][] cal1() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[N - 1 - i][j] = arr[i][j];
            }
        }

        return temp;
    }

    static int[][] cal2() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][M - 1 - j] = arr[i][j];
            }
        }

        return temp;
    }

    static int[][] cal3() {
        int[][] temp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[j][N - i - 1] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;

        return temp;
    }

    static int[][] cal4() {
        int[][] temp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[M - j - 1][i] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;

        return temp;
    }

    static int[][] cal5() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {//1번
                temp[i][j + M / 2] = arr[i][j];
            }
            for (int j = M / 2; j < M; j++) {//2번
                temp[i + N / 2][j] = arr[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {//3번
                temp[i][j - M / 2] = arr[i][j];
            }
            for (int j = 0; j < M / 2; j++) {//4번
                temp[i - N / 2][j] = arr[i][j];
            }
        }

        return temp;
    }

    static int[][] cal6() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {//1번>4번
                temp[i + N / 2][j] = arr[i][j];
            }
            for (int j = M / 2; j < M; j++) {//2번>1번
                temp[i][j - M / 2] = arr[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {//3번>2번
                temp[i - N / 2][j] = arr[i][j];
            }
            for (int j = 0; j < M / 2; j++) {//4번>3번
                temp[i][j + M / 2] = arr[i][j];
            }
        }

        return temp;
    }
}
