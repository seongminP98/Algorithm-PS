import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class StealCarrot18234 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N 종류의 당근
        int T = Integer.parseInt(st.nextToken()); // T 일
        PriorityQueue<Carrot> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Carrot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        long answer = 0;
        for (int i = 0; i < N; i++) {
            Carrot c = pq.poll();
            answer += (long) (i + T - N) * c.p + c.w;
        }
        System.out.println(answer);
    }

    // w의 맛, p 만큼 증가 영양제
    private static class Carrot implements Comparable<Carrot> {
        int w, p;

        public Carrot(int w, int p) {
            this.w = w;
            this.p = p;
        }

        @Override
        public int compareTo(Carrot o) {
            return Integer.compare(this.p, o.p);
        }
    }
}
