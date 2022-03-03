import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PutTheBox1965 {
    static int N;
    static int[] arr;
    static int[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d = new int[N];
        for (int i = 0; i < N; i++) {
            dp(i);
        }
        int answer = 0;
        for (int i : d) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }

    static void dp(int n) {
        if(d[n] == 0) {
            d[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    d[n] = Math.max(d[n], d[i] + 1);
                }
            }
        }
    }
}
