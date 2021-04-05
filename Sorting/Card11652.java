import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Card11652 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long max=0;
        long tmp=1;
        long result=0;
        if(N==1){
            result = arr[0];
        }
        for(int i=1; i<N; i++){
            if(arr[i]==arr[i-1]){
                tmp++;
            }else{
                tmp=1;
            }
            if(max<tmp){
                max=tmp;
                result = arr[i-1];
            }
        }
        System.out.print(result);
    }
}
