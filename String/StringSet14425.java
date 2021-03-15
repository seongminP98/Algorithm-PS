import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StringSet14425 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++){
            hm.put(br.readLine(), 1);
        }
        int count=0;
        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(hm.get(str) != null)
                count++;
        }
        System.out.println(count);
    }
}
