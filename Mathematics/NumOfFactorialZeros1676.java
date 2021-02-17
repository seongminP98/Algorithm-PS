import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumOfFactorialZeros1676 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int two=0;
        int five=0;

        for(int i=1; i<=n; i++){
            int m=i;
            if(m%10==2 || m%10==5 || m%10==0){
                while(m%2==0){
                    two++;
                    m/=2;
                }
                m=i;
                while(m%5==0){
                    five++;
                    m/=5;
                }
            }
        }
        System.out.println(Math.min(two,five));
    }
}
