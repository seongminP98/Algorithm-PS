import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumOfCombiZero2004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long countFive = five(n) - five(m) - five(n - m);
        long countTwo = two(n) - two(m) - two(n - m);


        System.out.println(Math.min(countTwo, countFive));
    }
    static int five(long num){
        int count =0;
        while(num>=5){
            count += num/5;
            num/=5;
        }
        return count;
    }
    static int two(long num){
        int count =0;
        while(num>=2){
            count += num/2;
            num/=2;
        }
        return count;
    }
}
