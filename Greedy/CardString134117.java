import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class CardString134117 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            ArrayDeque<String> ad = new ArrayDeque<String>();
            st = new StringTokenizer(br.readLine());

            ad.addFirst(st.nextToken());
            char first = ad.getFirst().charAt(0);
            while(st.hasMoreTokens()){
                char card = st.nextToken().charAt(0);
                if(card <= first){
                    ad.addFirst(card+"");
                    first = card;
                } else{
                    ad.add(card+"");
                }
            }
            String ans = "";
            for(int j=0; j<n; j++){
                ans += ad.pop();
            }
            System.out.println(ans);
        }
    }
}
