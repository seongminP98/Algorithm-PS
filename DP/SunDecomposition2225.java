import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SunDecomposition2225 {
    static int[][] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        d = new int[K+1][N+1];
        for(int i=1; i<K+1; i++){
            d[i][0]=1;
        }
        for(int i=1; i<K+1; i++){
            for(int j=1; j<N+1; j++){
                d[i][j] = (d[i][j-1]+d[i-1][j])%1000000000;
            }
        }
        System.out.println(d[K][N]);
    }
}
//2차원 배열에서 규칙이 왼쪽과 위쪽 더한 값이 구하려는 값이 됨.