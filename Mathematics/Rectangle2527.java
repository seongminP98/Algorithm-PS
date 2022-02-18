import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rectangle2527 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Rectangle r1 = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Rectangle r2 = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (D(r1, r2) || D(r2, r1)) {
                sb.append('d').append('\n');
            } else if (C(r1, r2) || C(r2, r1)) {
                sb.append('c').append('\n');
            } else if (B(r1, r2) || B(r2, r1)) {
                sb.append('b').append('\n');
            } else {
                sb.append('a').append('\n');
            }
        }
        System.out.print(sb);
    }

    static boolean D(Rectangle r1, Rectangle r2) {
        if (r1.x > r2.p) {
            return true;
        }
        if (r1.p < r2.x) {
            return true;
        }
        if (r1.y > r2.q) {
            return true;
        }
        if (r1.q < r2.y) {
            return true;
        }
        return false;
    }

    static boolean C(Rectangle r1, Rectangle r2) {
        if (r1.x == r2.p) {
            if (r1.y == r2.q) {
                return true;
            }
            if (r1.q == r2.y) {
                return true;
            }
        }
        if (r1.p == r2.x) {
            if (r1.y == r2.q) {
                return true;
            }
            if (r1.q == r2.y) {
                return true;
            }
        }
        return false;
    }

    static boolean B(Rectangle r1, Rectangle r2) { // 완전히 분리된 경우는 D에서 걸러짐.
        if (r1.x == r2.p) {
            return true;
        }
        if (r1.p == r2.x) {
            return true;
        }
        if (r1.y == r2.q) {
            return true;
        }
        if (r1.q == r2.y) {
            return true;
        }
        return false;
    }

    static class Rectangle {
        int x, y, p, q;

        public Rectangle(int x, int y, int p, int q) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.q = q;
        }
    }
}
