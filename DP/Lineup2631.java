import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lineup2631 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[n];
        d[0] = 1;
        int answer = 0;
        for(int i=1; i<n; i++) {
            d[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j]) {
                    d[i] = Math.max(d[i],d[j]+1);
                }
            }
            answer = Math.max(answer, d[i]); //가장 긴 오름차순의 길이
        }
        System.out.println(n-answer);
    }
}
