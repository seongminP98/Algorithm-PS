import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Scale2437 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = 0;
        for(int i=0; i<n; i++){
            if(arr[i] > min+1){ //누적합이 7인데 다음 추의 무게가 9이상이면 8은 못만든다.
                                //누적합이 7이고 다음 추가 5라면 12까지의 무게는 다 만들 수 있다.
                                //이미 누적합 까지의 무게는 만들 수 있으므로. 3+5,4+5,5+5,6+5,7+5
                break;
            }
            min += arr[i]; //누적합(i까지의 추로 만들 수 있는 무게)
        }
        System.out.println(min+1);
    }
}
