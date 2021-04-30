import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxDif10819 {
    static int N;
    static int[] arr;
    static int result;
    static int[] temp;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = 0;
        temp = new int[N];
        visited = new boolean[N];
        perm(0);
        System.out.println(result);
    }
    static void perm(int depth){ //순열로 모든 경우 계산
        if(depth == N){         //N개중 N개를 뽑아야되니 depth==N이면 배열 완성.
            int sum = 0;
            for(int i=0; i<N-1; i++){
                sum += Math.abs(temp[i]-temp[i+1]);
            }
            result = Math.max(result,sum);
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                temp[depth] = arr[i];
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}
