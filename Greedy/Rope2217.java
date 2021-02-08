import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rope2217 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];
        for(int i=0; i<n; i++){
            rope[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        int max=0;
        for(int i=0; i<n; i++){
            int w = rope[i]*(n-i);
            if(w>max)
                max=w;
        }
        System.out.println(max);
    }
}
