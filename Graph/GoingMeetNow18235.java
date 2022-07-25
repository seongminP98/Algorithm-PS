import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class GoingMeetNow18235 {
    static int N, A, B;
    static int[] da = {1, -1, 1, -1};
    static int[] db = {-1, 1, 1, -1};

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
        Queue<Duck> q = new LinkedList<>();

        boolean[][] visitedA = new boolean[N + 1][20];
        boolean[][] visitedB = new boolean[N + 1][20];
//        visitedA[A][0] = true;
//        visitedB[B][0] = true;
        q.add(new Duck(A, B, 0));
        while (!q.isEmpty()) {
            Duck c = q.poll();
            System.out.println("c = " + c);
            if (c.a == c.b) {
                System.out.println(c.cnt);
                return;
            }
            if (c.cnt >= 20) {
                System.out.println(-1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int na = c.a + (int) Math.pow(2, c.cnt) * da[i];
                int nb = c.b + (int) Math.pow(2, c.cnt) * db[i];
                if (na > 0 && na <= N && nb > 0 && nb <= N) {
                    System.out.println("visitedA[na][c.cnt] = " + visitedA[na][c.cnt]);
                    System.out.println("visitedB[nb][c.cnt] = " + visitedB[nb][c.cnt]);
                    System.out.println("na = " + na + " nb = " + nb + " c.cnt = " + c.cnt);

                    if (!visitedA[na][c.cnt] || !visitedB[nb][c.cnt]) {
                        visitedA[na][c.cnt] = true;
                        visitedB[nb][c.cnt] = true;
                        q.add(new Duck(na, nb, c.cnt + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }


    private static class Duck {
        int a, b, cnt;

        public Duck(int a, int b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }


        @Override
        public String toString() {
            return "Duck{" +
                    "a=" + a +
                    ", b=" + b +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
