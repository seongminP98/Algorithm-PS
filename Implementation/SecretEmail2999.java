import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecretEmail2999 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int R = (int) Math.sqrt(N);
        while (N % R != 0) {
            R--;
        }
        int C = N / R;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(str.charAt(i + R * j));
            }
        }
        System.out.print(sb);
    }
}
