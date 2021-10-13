import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberOfCountry124 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String answer = "";

        while(n>0) {
            int r = n%3;
            n /= 3;

            if(r==0) {
                n--;
                answer = "4"+answer;
            } else if(r==1) {
                answer = "1"+answer;
            } else {
                answer = "2"+answer;
            }
        }

        System.out.println("answer = " + answer);
    }
}
