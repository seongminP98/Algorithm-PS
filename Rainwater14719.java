import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rainwater14719 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for(int i=1; i<W-1; i++){
            int left = 0;
            int right = 0;
            for(int j=0; j<i; j++){
                left = Math.max(left,arr[j]); //기준 왼쪽에서 가장 긴 블록길이
            }
            for(int j=i+1; j<W; j++){
                right = Math.max(right,arr[j]); //기준 오른쪽에서 가장 긴 블록길이
            }
            if(arr[i]<left && arr[i]<right){
                ans += (Math.min(left,right)-arr[i]);
            }

        }

        System.out.print(ans);
    }
}
