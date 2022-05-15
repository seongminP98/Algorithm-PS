import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingHistorySG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Math.max(N, M);
        int[] before = new int[max];
        int[] after = new int[max];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            before[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            after[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < max; i++) {
            answer = Math.max(answer, after[i] - before[i]);
        }
        System.out.println(answer);

    }
}
