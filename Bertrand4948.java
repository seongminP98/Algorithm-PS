import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bertrand4948 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                break;

            System.out.println(bertrand(n));
        }
    }

    static int bertrand(int n){
        boolean[] arr = new boolean[2*n+1];
        arr[0]=arr[1] = true;
        for(int i=2; (i*i)<=2*n; i++){
            if(!arr[i]){
                for(int j=(i*i); j<=2*n; j+=i){
                    arr[j] = true;
                }
            }
        }
        int count = 0;
        for(int i=n+1; i<=2*n; i++){
            if(!arr[i])
                count++;
        }
        return count;
    }
}
