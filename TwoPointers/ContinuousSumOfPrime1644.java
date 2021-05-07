import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ContinuousSumOfPrime1644 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i*i<N+1; i++){
            if(isPrime[i]){
                for(int j=i*i; j<N+1; j+=i)
                    isPrime[j] = false;
            }
        }
//        for(int i=0; i<N+1; i++){
//            System.out.println(i+": "+isPrime[i]);
//        }

        int s = 2;
        int e = 2;
        int sum = 0;
        int count = 0;
        while(e<=N && s<=N){
            if(sum == N){
                count++;
                //System.out.println("s: "+s+" e: "+e);
            }


            if(sum<N){
                while(e<=N && !isPrime[e]){
                    e++;
                }
                sum += e++;
            } else{
                while(s<=N && !isPrime[s]){
                    s++;
                }
                sum -= s++;
            }
            //System.out.println(count);
        }
        if(isPrime[N])
            count++;
        System.out.println(count);
    }
}
