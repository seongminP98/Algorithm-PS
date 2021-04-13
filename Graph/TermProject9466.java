import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TermProject9466 {
    static int[] arr;
    static boolean[] visit;
    static boolean[] finished;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            visit = new boolean[n+1];
            finished = new boolean[n+1];
            arr = new int[n+1];
            count =0;
            for(int j=1; j<n+1; j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            for(int j=1; j<n+1; j++){
                if(!finished[j])
                    dfs(j);
            }
            System.out.println(n-count);
        }
    }
    static void dfs(int i){
        if (visit[i]) {
            finished[i] = true;
            count++; //팀 만들어진 사람
        } else {
            visit[i] = true;
        }

        if (!finished[arr[i]]) {
            dfs(arr[i]);
        }
        visit[i] = false;
        finished[i] = true;
    }
}
