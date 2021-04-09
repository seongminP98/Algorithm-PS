import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD1850 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n1 = Long.parseLong(st.nextToken());
        long n2 = Long.parseLong(st.nextToken());
        long A = Math.min(n1,n2);
        long B = Math.max(n1,n2);
        while(A>0){
            long tmp = A;
            A = B%A;
            B = tmp;
        }
        String ans = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<B; i++){
            sb.append(1);
        }
        System.out.print(sb);

    }
}
