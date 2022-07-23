import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder2528 {
    static int N, L;
    static int[] dir = {1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cl = Integer.parseInt(st.nextToken());
        int cd = Integer.parseInt(st.nextToken());
        int curStart = cd == 0 ? 0 : L - cl;
        int curEnd = cd == 0 ? cl : L;
        Bar cur = new Bar(curStart, curEnd, cd, cl);
        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nl = Integer.parseInt(st.nextToken());
            int nd = Integer.parseInt(st.nextToken());

            int nextStart = nd == 0 ? 0 : L - nl;
            int nextEnd = nd == 0 ? nl : L;
            Bar next = new Bar(nextStart, nextEnd, nd, nl);

            int originT = (L - next.l) * 2;
            int time = originT == 0 ? 0 : answer % originT;
            move(time, next);
            while (!canGo(cur, next)) {
                answer++;
                move(1, cur);
                move(1, next);
            }
            System.out.println();
            cur = next; // 되나?

        }
        System.out.println(answer);
    }

    private static void move(int time, Bar b) {
        b.start += dir[b.d] * time;
        b.end += dir[b.d] * time;
        if (b.start < 0) {
            b.end -= b.start;
            b.start = 0;
            b.d *= -1;
        } else if (b.end > L) {
            int diff = b.end - L;
            diff *= 2;
            b.start -= diff;
            b.end -= diff;
            b.d *= -1;
        }
    }

    private static boolean canGo(Bar cur, Bar next) {
        return (next.end - cur.start >= 0 && next.end - cur.start <= cur.l + next.l)
                || (cur.end - next.start >= 0 && cur.end - next.start <= cur.l + next.l);
    }

    private static class Bar {
        int start, end, d, l;

        @Override
        public String toString() {
            return "Bar{" +
                    "start=" + start +
                    ", end=" + end +
                    ", d=" + d +
                    ", l=" + l +
                    '}';
        }

        public Bar(int start, int end, int d, int l) {
            this.start = start;
            this.end = end;
            this.d = d;
            this.l = l;
        }
    }
}
