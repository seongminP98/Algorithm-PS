import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimeNumber2581 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean prime[] = new boolean[n+1];
        prime[0] = prime[1] = true;  //false가 소수

        for(int i=2; i*i<=n; i++){
            if(!prime[i]){
                for(int j=i*i; j<=n; j+=i)
                    prime[j] = true;
            }
        }
        boolean check = true;
        int min = 0;
        int sum = 0;
        for(int i=m; i<prime.length; i++){
            if(!prime[i]) {
                if (check) {
                    min = i;
                    check = false;
                }
                sum += i;
            }
        }

        if(!check){
            System.out.println(sum);
            System.out.println(min);
        } else
            System.out.println(-1);
    }
}
