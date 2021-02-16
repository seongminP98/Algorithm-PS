import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlphaCentauri1011 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = y-x;
            int max = (int)Math.sqrt(distance);
            int count=0;
            if(Math.sqrt(distance)==max)
                count = max*2-1;
            else if(distance<=max*max+max)
                count = max*2;
            else
                count = max*2+1;
            System.out.println(count);
        }
    }
}
