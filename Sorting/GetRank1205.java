import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetRank1205 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if(N==0){
            System.out.println(1);
            System.exit(1);
        }
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans=1;
        if(N==P){
            if(newScore<=arr[N-1]){
                System.out.println(-1);
            }else{
                for(int i=0; i<N; i++){
                    if(arr[i]>newScore){
                        ans++;
                    }else{
                        break;
                    }
                }
                System.out.println(ans);
            }
        } else{
            for(int i=0; i<N; i++){
                if(arr[i]>newScore){
                    ans++;
                }else{
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
