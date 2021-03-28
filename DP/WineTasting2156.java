import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WineTasting2156 {
    static int[] d;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        d = new int[n+1];
        d[0]=0;
        d[1]=arr[1];
        if(n>1){
            d[2]=arr[2]+arr[1];
        }

        System.out.println(dp(n));
    }
    static int dp(int n){
        if(n>2){
            if(d[n]==0){
                d[n] = Math.max(Math.max(arr[n-1]+dp(n-3),dp(n-2))+arr[n],dp(n-1));
            }
        }
        return d[n];
    }
}
//dp(n)은 n까지의 컵이 있을 때 결과가 가장 큰 값.
//n번째를 마셨다 : arr[n]+arr[n-1]+dp(n-3) 과 arr[n]+dp(n-2)중 큰 값 선택.
                //n번째를 마셨으니 arr[n]을 더하고 n-1을 마셨다고 생각하면 n-2는 안마셔야하므로 dp(n-3)을 더한다ㅏ.
                //n번째를 마셨으니 arr[n]을 더하고 n-1을 안마셨다고 생각하면 dp(n-2)를 더한다.
//n번째를 안마셨다 : dp(n-1)이된다.
//따라서 위에 2개 n번째를 마신경우와 안마신경우 중 큰 값을 선택.