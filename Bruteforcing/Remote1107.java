import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Remote1107 {
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                broken[Integer.parseInt(st.nextToken())]=true;
            }
        }
        int min = Math.abs(100-N);
        for(int i=0; i<=1000000; i++){
            int len = check(i); //숫자 누르는 횟수. len이 0이면 못 누르는 숫자.
            if(len>0){
                int p = Math.abs(N-i); //+,- 누르는 횟수
                min = Math.min(min,len+p);
            }
        }
        System.out.print(min);

    }
    static int check(int n){
        if(n==0){
            if(broken[0])
                return 0;
            else
                return 1;
        }
        int len=0;
        while(n>0){
            if(broken[n%10]){ //누를 수 없는 번호면 0 리턴.
                return 0;
            }
            n/=10;
            len += 1;
        }
        return len;
    }
}
