import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UCPC15904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] target = {'U', 'C', 'P', 'C'};
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (target[idx] == str.charAt(i)) {
                idx++;
            }
            if (idx == 4) {
                System.out.println("I love UCPC");
                System.exit(0);
            }
        }
        System.out.println("I hate UCPC");
    }
}
