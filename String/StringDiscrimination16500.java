import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StringDiscrimination16500 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        int[] dp = new int[101];

        for(int i=s.length()-1; i>=0; i--){
            for(int j=i+1; j<s.length(); j++){
                if(dp[j]==1){
                    if(set.contains(s.substring(i,j)))
                        dp[i] = 1;
                }
            }
            if(set.contains(s.substring(i)))
                dp[i] = 1;
        }

        System.out.println(dp[0]);
    }
}