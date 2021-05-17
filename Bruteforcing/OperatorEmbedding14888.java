import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OperatorEmbedding14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[] arr;
    static int[] op;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[4]; //+ - * /
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        solve(1,arr[0]);
        System.out.println(max);
        System.out.println(min);
        System.out.println(count);
    }
    static void solve(int depth, int num){
        if(depth == N){
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }

        for(int i=0; i<4; i++){
            if(op[i]>0){
                op[i]--;
                switch (i) {
                    case 0:
                        solve(depth + 1, num + arr[depth]);
                        break;
                    case 1:
                        solve(depth + 1, num - arr[depth]);
                        break;
                    case 2:
                        solve(depth + 1, num * arr[depth]);
                        break;
                    case 3:
                        solve(depth + 1, num / arr[depth]);
                        break;
                }
                op[i]++;
            }
        }
    }
}
