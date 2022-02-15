import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SanggeunTravel9372 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for(int i=0; i<M; i++) {
                br.readLine();
            }
            sb.append(N-1).append('\n');
        }
        System.out.print(sb);
    }
}
/**
 * MST 문제인데 가중치가 0. 그럼 N-1이 답
 */
 