import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Zoo1309 {
    static int N;
    static int[][] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new int[N][3];
        d[0][0] = 1; //사자를 넣지 않은경우
        d[0][1] = 1; //사자를 왼쪽에만 넣은경우
        d[0][2] = 1; //사자를 오른쪽에만 넣은경우
        int ans = dp(N-1,0)+dp(N-1,1)+dp(N-1,2);
        System.out.println(ans%9901);
    }
    static int dp(int n, int i){
        if(d[n][i]==0){
            if(i==0){
                d[n][i] = dp(n-1,0)+dp(n-1,1)+dp(n-1,2);
            }
            else if(i==1){
                d[n][i] = dp(n-1,0)+dp(n-1,2);
            }
            else if(i==2){
                d[n][i] = dp(n-1,0)+dp(n-1,1);
            }
        }
        return d[n][i]%9901;
    }
}
