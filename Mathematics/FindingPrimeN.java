import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//에라토스테네스의 체
public class FindingPrimeN {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean check[] = new boolean[n+1];  //전부 false로 설정.
        check[0]=check[1]=true;
        for(int i=2; (i*i)<=n; i++){
            if(!check[i]){
                for(int j=(i*i); j<=n; j+=i){ //i제곱의 배수는 소수가 아님.
                    check[j] = true;          //소수가 아니면 true.
                }
            }
        }

        for(int i=m; i<=n; i++){
            if(!check[i])
                System.out.println(i);
        }
    }
}
