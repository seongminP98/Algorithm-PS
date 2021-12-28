import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Thirty10610 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        char[] nChar = n.toCharArray();
        Arrays.sort(nChar);

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = nChar.length - 1; i >= 0; i--) {
            int num = nChar[i] - '0';
            sum += num;
            sb.append(num);
        }

        if (nChar[0] != '0' || sum % 3 != 0) { //30의 배수이려면 모든 자릿수의 합이 3의 배수여야함. & 0이 있어야함.
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
