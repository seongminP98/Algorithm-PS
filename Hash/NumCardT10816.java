import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumCardT10816 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(hm.containsKey(num))
                hm.put(num,hm.get(num)+1);
            else
                hm.put(num,1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] ans = new int[M];
        for(int i=0; i<M; i++){
            int searchNum = Integer.parseInt(st.nextToken());
            ans[i] = hm.getOrDefault(searchNum, 0); //(key, default)  찾는key가 존재하면
                                                            // 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값 반환.
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
