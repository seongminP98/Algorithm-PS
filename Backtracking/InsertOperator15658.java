import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertOperator15658 {
    static int[] arr;
    static int[] op;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        op = new int[4]; //+ - * /
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        solve(1,arr[0]);
        System.out.println(max+" "+min);
    }
    static void solve(int depth, int sum){
        if(depth == N){
            min = Math.min(min,sum);
            max = Math.max(max,sum);
            System.out.println("sum:"+sum);
            return;
        }
        for(int i=0; i<4; i++){
            if(op[i]>0){
                op[i]--;
                switch (i){
                    case 0:
                        solve(depth+1,sum+arr[depth]);
                        break;
                    case 1:
                        solve(depth+1,sum-arr[depth]);
                        break;
                    case 2:
                        solve(depth+1,sum*arr[depth]);
                        break;
                    case 3:
                        solve(depth+1,sum/arr[depth]);
                        break;
                }
                op[i]++;
            }

        }
    }
}
