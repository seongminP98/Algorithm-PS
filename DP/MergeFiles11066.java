import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeFiles11066 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K+1];
            int[] sum = new int[K+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] += sum[i-1] + arr[i];
            }
            int[][] d = new int[K+1][K+1];

            for(int i=1; i<=K; i++) {
                for(int from = 1; from + i <=K; from++) {
                    int to = from + i;
                    d[from][to] = Integer.MAX_VALUE;
                    for(int div = from; div<to; div++) {
                        d[from][to] = Math.min(d[from][to], d[from][div] + d[div+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }
            System.out.println(d[1][K]);
        }
    }
}
