import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class PoppingBalloon2346 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Deque<Balloon> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dq.add(new Balloon(i, num));
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.getFirst().order+" ");
            int number = dq.poll().number;
            if(dq.isEmpty())
                break;

            if(number > 0) {
                number-=1;
                for(int i=0; i<number; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for(int i=0; i<Math.abs(number); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
    static class Balloon{
        int order, number;

        public Balloon(int order, int number) {
            this.order = order;
            this.number = number;
        }
    }
}
