import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class antenna18310 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int home[] = new int[n];
        for(int i=0; i<n; i++){
            home[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(home);
        int result = 0;

        int mid = n/2;
        if(n%2==1){
            result = home[mid];
        } else{
            int sum=0;
            int sum2=0;
            for(int i=0; i<n; i++){
                sum += home[mid-1]-home[i];
                sum2 += home[mid]-home[i];
            }
            if(sum<=sum2)
                result=home[mid-1];
            else
                result=home[mid];
        }
        System.out.println(result);
    }
}
