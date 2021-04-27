import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CombiArr11728 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        int n = N+M;
        int[] ans = new int[n];
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int j=0, k=0;
        for(int i=0; i<n; i++){
            if(j>=N){
                ans[i] = arrB[k];
                k++;
                continue;
            }
            if(k>=M){
                ans[i] = arrA[j];
                j++;
                continue;
            }

            if(arrA[j]>arrB[k]){
                ans[i] = arrB[k];
                k++;
            } else{
                ans[i] = arrA[j];
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
