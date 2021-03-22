import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SkipLogs11497 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int max = arr[1]-arr[0];
            if(max<arr[N-1]-arr[N-2])
                max = arr[N-1]-arr[N-2];
            for(int j=0; j<N-2; j++){
                if(max<arr[j+2]-arr[j])
                    max = arr[j+2]-arr[j];
            }
            System.out.println(max);
        }
    }
}
