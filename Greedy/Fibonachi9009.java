import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Fibonachi9009 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] f = new int[45];

        f[0] = 0;
        f[1] = 1;
        for(int i=2; i<f.length; i++){
            f[i] = f[i-1]+f[i-2];
        }

        for(int i=0; i<T; i++){

            int result[] = new int[45];
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for(int k=44; k>=0; k--){
                if(n>=f[k]){
                    result[count] = f[k];
                    n -= f[k];
                    count++;
                }
            }
            for(int m=0; m<result.length; m++){
                Arrays.sort(result);
                if(result[m]!=0){
                    System.out.print(result[m]+" ");
                }
            }
            System.out.println();
        }
    }
}
