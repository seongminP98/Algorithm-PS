import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EasySolveProblem1292 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];
        int num = 1;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                if (num == 1001)
                    break;

                arr[num] = i+arr[num-1];
                num++;
            }
        }
        System.out.println(arr[B]-arr[A-1]);
    }
}
