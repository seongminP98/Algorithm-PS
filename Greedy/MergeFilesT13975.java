import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MergeFilesT13975 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long answer = 0;
            while (!pq.isEmpty()) {
                if (pq.size() == 1) {
                    sb.append(answer).append('\n');
                    break;
                } else {
                    long file1 = pq.poll();
                    long file2 = pq.poll();
                    pq.add(file1 + file2);
                    answer += (file1 + file2);
                }
            }
        }
        System.out.println(sb);
    }
}
