import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameD2847 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] point = new int[n];
        for(int i=0; i<n; i++){
            point[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i=n-2; i>=0; i--){
            if(point[i]>=point[i+1]){
                count += point[i]-point[i+1]+1;
                point[i] = point[i+1]-1;
            }
        }
        System.out.println(count);
    }
}
