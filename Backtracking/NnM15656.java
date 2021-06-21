import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NnM15656 {
    static int N,M;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        solution(0,sb);
        System.out.print(sb);
    }
    static void solution(int depth,StringBuilder sb){
        if(depth==M){
            for(int i=0; i<M; i++){
                sb.append(result[i]+" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            result[depth] = arr[i];
            solution(depth+1,sb);
        }
    }
}
