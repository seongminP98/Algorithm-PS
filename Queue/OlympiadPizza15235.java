import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OlympiadPizza15235 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            q.add(i);
        }
        int[] answer = new int[N];
        int second = 0;
        while (!q.isEmpty()) {
            int next = q.poll();
            second++;
            if (--arr[next] == 0) {
                answer[next] = second;
            } else {
                q.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
