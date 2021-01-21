import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPrimeNum1978 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int count = 0;

        while(st.hasMoreTokens()){
            boolean check = true;
            int num = Integer.parseInt(st.nextToken());
            if(num!=1) {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        check = false;
                    }
                }
            }
            else
                check = false;
            if(check)
                count++;
        }
        System.out.println(count);
    }
}
