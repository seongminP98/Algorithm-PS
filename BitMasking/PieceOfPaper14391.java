import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PieceOfPaper14391 {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int answer = 0;
        int cnt = (int) Math.pow(2, N * M);
        for (int k = 0; k < cnt; k++) {
//            System.out.println("k = " + k);
            boolean[][] check = new boolean[N][M];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (check[i][j]) continue;
                    check[i][j] = true;
                    int value = arr[i][j];
                    int t = i * M + j;
                    int r = i;
                    int c = j;
                    if ((k & (1 << t)) == 0) { // 아래로
//                        System.out.println("아래로");
                        r++;
                        while (true) {
//                            System.out.println("r = " + r + " c = " + c);
                            if (r >= N || (k & (1 << (r * M + c))) != 0) {
                                break;
                            }
                            value *= 10;
                            value += arr[r][c];
                            check[r][c] = true;
                            r++;

                        }
//                        System.out.println("아래로 value = " + value);
                    } else { // 오른쪽으로
//                        System.out.println("오른쪽으로");
                        c++;
                        while (true) {
//                            System.out.println("::"+(k & (r * N + c)));
//                            System.out.println("r = " + r + " c = " + c);

                            if (c >= M || (k & (1 << (r * M + c))) == 0) {
                                break;
                            }
                            value *= 10;
                            value += arr[r][c];

                            check[r][c] = true;
                            c++;

                        }
//                        System.out.println("오른쪽으로 value = " + value);
                    }
                    sum += value;
                }
            }
//            System.out.println("sum = " + sum);
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);


//        cut = N * (M - 1) + M * (N - 1);
//        cut = (int) Math.pow(2, cut);
////        System.out.println("cut = " + cut);
////        System.out.println("(1<<1) = " + (1 << 1));
////        System.out.println("(1<<1) = " + (1 << 2));
////        System.out.println("(1<<1) = " + (1 << 3));
//        int answer = 0;
//        for (int k = 1; k <= cut; k++) {
////            System.out.println("k = " + k);
//            boolean[][] check = new boolean[N][M];
//            int sum = 0;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    if (check[i][j]) continue;
//                    if (i == N - 1 && j == M - 1) {
//                        sum += arr[i][j];
//                    }
//                    check[i][j] = true;
//                    if (j != M - 1) {
//                        int right = i * (N + M - 1) + j;
////                        System.out.println("right = " + right);
////                        System.out.println("1<<right = "+ (1<<right));
//                        if ((k & (1 << right)) > 0) { // 오른쪽 안잘림
//                            int value = arr[i][j];
//                            int r = i;
//                            int c = j;
//                            while (true) {
//                                if (c == M - 1 || (1 << (k & (r * (N + M - 1) + c))) == 0) break;
//                                value *= 10;
//                                c++;
//                                value += arr[r][c];
//                                check[r][c] = true;
//                            }
////                            System.out.println(" r value = " + value);
//                            sum += value;
//                            continue;
//                        }
//                    }
//                    if (i != N - 1) {
//                        int down = i * (N + M - 1) + (M - 1) + j;
////                        System.out.println("down = " + down);
////                        System.out.println("1<<down = "+ (1<<down));
//                        if ((k & (1 << down)) > 0) { // 아래 안잘림
//                            int value = arr[i][j];
//                            int r = i;
//                            int c = j;
//                            while (true) {
//                                if (r == N - 1 || (1 << (k & (r * (N + M - 1) + (M - 1) + c))) == 0) break;
//                                value *= 10;
//                                r++;
//                                value += arr[r][c];
//                                check[r][c] = true;
//                            }
////                            System.out.println(" d value = " + value);
//
//                            sum += value;
//                        }
//                    }
//                }
//            }
//            System.out.println("k = " + k);
//            System.out.println("sum = " + sum);
//            answer = Math.max(answer, sum);
//        }
//        System.out.println(answer);


    }
}
