import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MemorizeWords18119 {
    static int N, M;
    static int[] arrBit;
    static char[] alphabet;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrBit = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arrBit[i] |= (1 << s.charAt(j) - 97);
            }
        }
//        for (int i : arrBit) {
//            System.out.println(Integer.toBinaryString(i));
//        }
        alphabet = new char[26];
        char c = 97;
        for (int i = 25; i >= 0; i--) {
            alphabet[i] = c++;
        }
        int flag = (1 << 27) - 1; //모든 알파벳 알고있음.

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            char x = st.nextToken().charAt(0);

            if (cmd == 1) { // 잊음.
                flag = flag ^ 1 << x - 97;
            } else { // 기억해냄.
                flag = flag | 1 << x - 97;
            }

            int count = 0;
            for (int word : arrBit) {
                // 현재 단어의 알파벳을 알고 있으면 & 연산 했을 때 1이나옴.
                if ((word & flag) == word) {
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}
