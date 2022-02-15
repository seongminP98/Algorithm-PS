import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
    static int N, r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        solution(N, 0, 0, 0);
    }

    static void solution(int n, int x, int y, int num) {
        if (n == 1) {
            for (int i = x; i < x + 2; i++) {
                for (int j = y; j < y + 2; j++) {
                    if (i == r && j == c) {
                        System.out.println(num);
                        System.exit(0);
                    }
                    num++;
                }
            }
            return;
        }

        if (r >= x + (int) Math.pow(2, n - 1)) {
            if (c >= y + (int) Math.pow(2, n - 1)) {
                solution(n - 1, x + (int) Math.pow(2, n - 1), y + (int) Math.pow(2, n - 1), num + (int) Math.pow(2, (n - 1) * 2) * 3);//우측아래
            } else {
                solution(n - 1, x + (int) Math.pow(2, n - 1), y, num + (int) Math.pow(2, (n - 1) * 2) * 2);//좌측아래
            }
        } else {
            if (c >= y + (int) Math.pow(2, n - 1)) {
                solution(n - 1, x, y + (int) Math.pow(2, n - 1), num + (int) Math.pow(2, (n - 1) * 2));//우측위
            } else {
                solution(n - 1, x, y, num); //좌측위
            }
        }
    }
}
/**
 * num의 변화. 차례대로 좌측위 > 우측위 > 좌측아래 > 우측아래
 * n= 2->1
 * 0 4 8 12
 *
 * n= 3->2
 * 0 16 32 48
 *
 * n= 4->3
 * 0 64 128 192
 *
 * n= 5->4
 * 0 256 512 768
 *
 * 2^2 2^4 2^6
 * (n-1)*2
 */
