import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EatEaten7795 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arrA = new int[N];
            int[] arrB = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            int count = 0;
            int pivot = 0;
            for(int i=0; i<N; i++){
                while(true){
                    if(pivot==M)
                        break;
                    if(arrA[i]>arrB[pivot])
                        pivot++;
                    else
                        break;
                }
                count += pivot;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
