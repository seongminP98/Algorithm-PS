import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class GoingMeetNow18235 {
    static int N, A, B;
    static int[] d = {1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        if (Math.abs(A - B) % 2 == 1) {
            System.out.println(-1);
            return;
        }

        boolean[][] visitedA = new boolean[N + 1][20];
        boolean[][] visitedB = new boolean[N + 1][20];

        Queue<Integer> qA = new LinkedList<>();
        Queue<Integer> qB = new LinkedList<>();
        qA.add(A);
        qB.add(B);
        int cnt = 0;
        while (!qA.isEmpty()) {
            int size = qA.size();
            while (size-- > 0) {
                int c = qA.poll();
                if (cnt >= 20) {
                    break;
                }
                for (int i = 0; i < 2; i++) {
                    int na = c + (int) Math.pow(2, cnt) * d[i];
                    if (na > 0 && na <= N && !visitedA[na][cnt + 1]) {
                        qA.add(na);
                        visitedA[na][cnt + 1] = true;
                    }
                }
            }

            cnt++;
        }

        cnt = 0;
        while (!qB.isEmpty()) {
            int size = qB.size();
            while (size-- > 0) {
                int c = qB.poll();
                if (visitedA[c][cnt]) {
                    System.out.println(cnt);
                    System.exit(0);
                }
                if (cnt >= 20) {
                    break;
                }
                for (int i = 0; i < 2; i++) {
                    int nb = c + (int) Math.pow(2, cnt) * d[i];
                    if (nb > 0 && nb <= N && !visitedB[nb][cnt + 1]) {
                        qB.add(nb);
                        visitedB[nb][cnt + 1] = true;
                    }
                }
            }
            cnt++;
        }
        System.out.println(-1);
    }

}
