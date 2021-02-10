import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB16953 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count=1;
        while(true){
            if(a==b)
                break;
            else if(a>b){
                count = -1;
                break;
            }
            if(b%10 == 1){
                b/=10;
                count++;
            } else if(b%2 == 0){
                b/=2;
                count++;
            } else{
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}
