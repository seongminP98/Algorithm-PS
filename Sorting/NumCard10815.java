import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumCard10815 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cardN[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cardN[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int cardM[] = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            cardM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardN);

        for(int i=0; i<m; i++){
            int check = 0;
            int left = 0;
            int right = n-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(cardN[mid]>cardM[i]){
                    right = mid-1;
                }
                else if(cardN[mid]<cardM[i]){
                    left = mid+1;
                }
                else {
                    check = 1;
                    break;
                }
            }
            System.out.print(check+" ");
        }
    }
}
