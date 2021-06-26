import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS9251 {
    static char[] s1;
    static char[] s2;

    static Integer[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        dp = new Integer[s1.length][s2.length];
        LCS(s1.length-1,s2.length-1);
        System.out.println(dp[s1.length-1][s2.length-1]);
    }
    static int LCS(int x, int y){
        if(x<0 || y<0){
            return 0;
        }
        if(dp[x][y] == null){
            if(s1[x] == s2[y]){
                dp[x][y] = LCS(x-1,y-1) + 1;
            }else{
                dp[x][y] = Math.max(LCS(x-1,y),LCS(x,y-1));
            }
        }
        return dp[x][y];
    }
}
