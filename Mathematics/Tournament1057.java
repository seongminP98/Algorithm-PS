import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tournament1057 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int min = Math.min(kim,lim);
        int max = Math.max(kim,lim);
        int count = 0;

        while(true){
            count++;
            if(max-min==1 && min%2==1 && max%2==0){
                break;
            } else{
                if(max%2==1)
                    max = max/2 +1;
                else
                    max = max/2;
                if(min%2==1)
                    min = min/2 +1;
                else
                    min = min/2;
            }
        }
        System.out.println(count);
    }
}
