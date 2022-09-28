import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrintSwirlBeautifully1022 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int N = r2 - r1 + 1;
        int M = c2 - c1 + 1;
        int[][] arr = new int[N][M];

        int num = 1;
        int x = 0;
        int y = 0;
        int count = 0;
        int sumCnt = N * M;
        int d = 0;
        // 1,1,2,2,3,3,4,4 - 오른쪽1번 위1번 왼쪽2번 아래2번 오른쪽3번 ...
        int dirNum = 1;
        loop:
        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < dirNum; j++) {
                    if (count == sumCnt) break loop;
                    if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                        arr[x - r1][y - c1] = num;
                        count++;
                    }
                    x += dx[d];
                    y += dy[d];
                    num++;
                }
                d++;
                d %= 4;
            }
            dirNum++;
        }
        int len = Integer.toString(num - 1).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(" ".repeat(Math.max(0, len - Integer.toString(arr[i][j]).length() + 1)));
                if (j == 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}