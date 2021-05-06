import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSubseq1182 {
    static int N, S;
    static int[] arr;
    static int count;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        check = new boolean[N];
        count = 0;
        solve(0);
        if(S==0)
            count--;
        System.out.println(count);

    }
    static void solve(int start){
        int sum = 0;
        for(int i=0; i<N; i++){
            if(check[i])
                sum+=arr[i];
        }
        if(sum == S){
            count++;
        }

        for(int i=start; i<N; i++){
            check[i] = true;
            solve(i+1);
            check[i]=false;
        }
    }
}
