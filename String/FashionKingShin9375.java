import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FashionKingShin9375 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n; i++){
            int result = 1;
            int t = Integer.parseInt(br.readLine());
            HashMap<String,Integer> hm = new HashMap<>();
            for(int j=0; j<t; j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                if(hm.containsKey(kind)){
                    hm.put(kind,hm.get(kind)+1);
                } else{
                    hm.put(kind,1);
                }
            }
            for(int val : hm.values()){ //각 종류 중 하나씩 선택. 안입는거 포함(+1)
                result*=(val+1);
            }
            result--; //하나도 안입었을 때 제외
            System.out.println(result);
        }
    }
}
