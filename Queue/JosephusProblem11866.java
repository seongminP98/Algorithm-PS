import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JosephusProblem11866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int i=1; i<=N; i++){
            list.add(i);
        }
        while(!list.isEmpty()){
            idx+=K-1;
            idx%=list.size();
            if(list.size()==1){
                sb.append(list.get(idx)).append('>');
            }else{
                sb.append(list.get(idx)).append(", ");
            }
            list.remove(idx);
        }

        System.out.print(sb);
    }
}
