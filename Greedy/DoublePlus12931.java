import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DoublePlus12931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        while (true) {
            for (int i = 0; i < N; i++) {
                if (arr[i] % 2 == 1) {
                    arr[i]--;
                    answer++;
                }
            }
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (arr[i] > 0) {
                    flag = true;
                    arr[i] /= 2;
                }
            }
            if(!flag) break;
            answer++;
        }
        System.out.println(answer);
    }
}
