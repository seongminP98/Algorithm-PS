import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDLCM2609 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int max = Math.max(n1,n2); //둘 중 큰수
        int min = Math.min(n1,n2); //둘 중 작은수

        while(min!=0){ //gcd 유클리드 호제법법
            int r = max % min;
            max = min;
            min = r;
        }
        //max가 gcd가 된다.
        //n1 * n2 == gcd * lcm
        int lcm = n1 * n2 / max;

        System.out.println(max);
        System.out.println(lcm);
    }
}
