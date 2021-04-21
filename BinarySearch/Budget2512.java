import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Budget2512 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        long min = 1;
        long max = arr[N-1];
        long middle = 0;
        while(max>=min){
            middle = (max+min)/2;
            long sum = 0;
            for(int i=0; i<N; i++){
                if(arr[i]<=middle){
                    sum += arr[i];
                } else
                    sum += middle;
            }
            if(sum==M){
                max = middle;
                break;
            } else if(sum>=M){
                max = middle-1;
            } else
                min = middle+1;
        }
        System.out.println(max);
    }
}
