import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfGCD {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            for(int j=0; j<n; j++){
                for(int k=j+1; k<n; k++){
                    sum += gcd(arr[j],arr[k]);
                }
            }
            System.out.println(sum);
        }
    }
    static int gcd(int n, int m){
        int max = Math.max(n,m);
        int min = Math.min(n,m);

        while(min!=0){
            int tmp = max%min;
            max = min;
            min = tmp;
        }
        return max;
    }
}
