import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeTbyO12852 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        int before[] = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            before[i] = i - 1;
            if (i % 3 == 0 && d[i / 3] + 1 < d[i]) {
                d[i] = d[i / 3] + 1;
                before[i] = i / 3;
            }
            if (i % 2 == 0 && d[i / 2] + 1 < d[i]) {
                d[i] = d[i / 2] + 1;
                before[i] = i / 2;
            }
        }
        System.out.println(d[n]);

        while (n > 0) {
            sb.append(n).append(" ");
            n = before[n];
        }
        System.out.println(sb);
    }
}
