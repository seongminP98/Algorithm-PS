import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProjectTeam20044 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[2*n];
        for(int i=0; i<n*2; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = arr[0]+arr[2*n-1];
        int arrw[] = new int[n];
        for(int i=0; i<n; i++){
            arrw[i] = arr[i]+arr[2*n-i-1];
            if(min>arrw[i])
                min = arrw[i];
        }
        System.out.println(min);

    }
}
