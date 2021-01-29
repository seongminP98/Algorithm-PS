import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SickKnight1783 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result;

        if(n==1) {
            result = 1;
        } else if(n==2) {
            result = Math.min((m + 1) / 2, 4);
        } else if(m>=7){
            result=m-2;
        } else{
            result=Math.min(m,4);
        }
        System.out.println(result);

    }
}
