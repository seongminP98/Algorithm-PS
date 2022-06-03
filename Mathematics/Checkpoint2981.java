import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Checkpoint2981 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int g = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            int n1 = arr[i] - arr[i - 1];
            if (g > n1) {
                g = gcd(n1, g);
            } else {
                g = gcd(g, n1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= g; i++) {
            if (g % i == 0) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        while (a > 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
