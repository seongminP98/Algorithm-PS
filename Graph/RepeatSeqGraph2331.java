import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepeatSeqGraph2331 {
    static int[] visit = new int[1000000];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        System.out.print(dfs(A,P,1));
    }
    static int dfs(int a, int p, int cnt){
        if(visit[a]!=0)
            return visit[a]-1;

        visit[a]=cnt;
        int n=0;
        while(a!=0){
            n+=Math.pow(a%10,p);
            a/=10;
        }
        return dfs(n,p,cnt+1);
    }
}
