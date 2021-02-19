import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DateCalc1476 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;
        int count = 1;

        while(e!=E || s!=S || m!=M){
            e++;
            s++;
            m++;
            count++;
            if(e==16)
                e=1;
            if(s==29)
                s=1;
            if(m==20)
                m=1;
        }
        System.out.println(count);
    }
}
