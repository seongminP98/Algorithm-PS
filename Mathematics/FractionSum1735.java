import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FractionSum1735 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int B1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        int B = B1*B2 / gcd(B1,B2);
        A1 = A1*(B/B1);
        A2 = A2*(B/B2);
        int A = A1+A2;
        int d = gcd(A,B);
        if(A%d==0){
            A /=d;
            B /=d;
        }

        System.out.print(A+" ");
        System.out.print(B);

    }
    static int gcd(int n1, int n2){
        if(n2==0){
            return n1;
        } else{
            return gcd(n2, n1%n2);
        }
    }
}
