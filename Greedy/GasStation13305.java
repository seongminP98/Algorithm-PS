import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation13305 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long[] d = new long[n-1]; //거리
        long[] f = new long[n]; //연료 가격
        for(int i=0; i< n-1; i++){
            d[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++){
            f[i]=Integer.parseInt(st.nextToken());
        }
        long result = d[0]*f[0]; //처음 주유
        long min = f[0];
        for(int i=1; i<n-1; i++){
            if(min>f[i]){
                min = f[i];
            }
            result+=min*d[i];
        }
        System.out.println(result);
    }
}
