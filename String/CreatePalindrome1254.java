import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreatePalindrome1254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        boolean check = false; // 홀수
        if (S.length() % 2 == 0) {
            check = true; //짝수
        }
        int answer = S.length();
        for (int i = 0; i < S.length(); i++) {
            int mid = (S.length() - i) / 2 + i;
            String front = S.substring(i, mid);
            String frontR = new StringBuffer(front).reverse().toString();
            if (check) { //짝수
                String back = S.substring(mid);
                if (frontR.equals(back)) {
                    System.out.println(answer + i);
                    System.exit(0);
                }
                check = false;
            } else { //홀수
                String back = S.substring(mid + 1);
                if (frontR.equals(back)) {
                    System.out.println(answer + i);
                    System.exit(0);
                }
                check = true;
            }
        }
    }
}
