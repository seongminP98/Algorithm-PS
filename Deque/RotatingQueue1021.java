import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RotatingQueue1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            int mid = dq.size() / 2;
            int index = dq.indexOf(next);
            if (mid >= index) { //앞에서
                while (true) {
                    int cValue = dq.pollFirst();
                    if (cValue == next) {
                        break;
                    } else {
                        dq.addLast(cValue);
                        answer++;
                    }
                }

            } else { //뒤에서
                while (true) {
                    int cValue = dq.pollLast();
                    if (cValue == next) {
                        answer++;
                        break;
                    } else {
                        dq.addFirst(cValue);
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
