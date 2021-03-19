import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DBJ1764 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N+M];
        for(int i=0; i<arr.length; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int result=0;
        for(int i=1; i<arr.length; i++){
            if(arr[i].equals(arr[i-1])){
                sb.append(arr[i]+"\n");
                result++;
            }
        }
        System.out.println(result);
        System.out.println(sb.toString());
    }
}
