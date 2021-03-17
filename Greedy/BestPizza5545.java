import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BestPizza5545 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//토핑의 종류
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());//도우의 가격
        int B = Integer.parseInt(st.nextToken());//토핑의 가격
        int C = Integer.parseInt(br.readLine());//도우의 열량
        Integer arr[] = new Integer[N];//토핑의 열량
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int result = C/A;
        int p = A;
        int cal = C;
        for(int i=0; i<N; i++){
            p += B;
            cal += arr[i];
            int temp = cal/p;
            if(result<=temp)
                result = temp;
            else
                break;
        }
        System.out.println(result);
    }
}
