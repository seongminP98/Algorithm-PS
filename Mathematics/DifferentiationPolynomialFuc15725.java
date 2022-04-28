import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DifferentiationPolynomialFuc15725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split("x");
        if (str.equals("x")) {
            System.out.println(1);
            System.exit(0);
        }
        if (split.length == 1) {
            if (split[0].equals("-")) {
                System.out.println(-1);
                System.exit(0);
            }
            if (str.charAt(str.length() - 1) == 'x') {
                System.out.println(str.substring(0, str.length() - 1));
            } else {
                System.out.println(0);
            }

            System.exit(0);
        }

        String answer = split[0];

        answer = answer.equals("") ? "1" : answer;
        answer = answer.equals("-") ? "-1" : answer;
        System.out.println(answer);
    }
}
