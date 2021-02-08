import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorization11653 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i=2;
        while(true){
            if(n==1){
                break;
            }
            while(n%i==0){
                System.out.println(i);
                n/=i;
            }
            i++;
        }
    }
}
