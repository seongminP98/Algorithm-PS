import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pattern3164 {
    static long answer = 0;
    static long overlap = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        solution(p1, p2);
        solution(new Point(p1.y, p1.x), new Point(p2.y, p2.x));

        System.out.println(answer - overlap);
    }

    private static void solution(Point p1, Point p2) {
        long count = 0;
        long result = 0;
        for (int i = p1.x + 1; i <= p2.x; i++) {
            if (i % 2 == 0) {
                int temp = Math.min(i, p2.y) - p1.y;
                if (temp > 0) {
                    count++;
                    result += temp;
                }
            }
        }
        overlap = Math.min(overlap, count);
        answer += result;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
