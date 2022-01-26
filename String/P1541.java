import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
        StringTokenizer first = new StringTokenizer(sub.nextToken(), "+");

        int answer = 0;
        while (first.hasMoreTokens()) {
            answer += Integer.parseInt(first.nextToken());
        }
        while (sub.hasMoreTokens()) {
            StringTokenizer plus = new StringTokenizer(sub.nextToken(), "+");

            while (plus.hasMoreTokens()) {
                answer -= Integer.parseInt(plus.nextToken());
            }
        }
        System.out.println(answer);
    }
}
