import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EasySteps10844 {
    static Long[][] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new Long[n+1][10];
        for(int i=0; i<10; i++){
            d[1][i] = 1L;
        }
        long sum=0;
        for(int i=1; i<10; i++){
            sum+=dp(n,i);
        }
        System.out.println(sum%1000000000);
    }
    static long dp(int n,int i){ //n은 자릿수, i는 자릿값.  ex) n=4일 경우 4자릿수 숫자에서 4번째 수가 1일 때, 앞자리는
        if(n==1)                 //0또는2이다. 그럼 n=3일 때 구해놓은 3번째 자릿수가 0일때와 2일때의 경우를 합하면 된다.
            return d[n][i];      //하지만 4번째 자릿수가 9나 0일 경우 앞자리는 8과 1밖에 못오기 때문에 따로 조건을 걸어준다.
        if(d[n][i]==null){
            if(i==0){
                d[n][i] = dp(n-1,1);
            } else if(i==9){
                d[n][i] = dp(n-1, 8);
            } else{
                d[n][i] = dp(n-1,i-1)+dp(n-1,i+1);
            }
        }
        return d[n][i]%1000000000;
    }
}
