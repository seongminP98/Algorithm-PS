import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken(); //길이가 B보다 짧거나 같음
        String B = st.nextToken();

        int answer = A.length();

        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            int diff = 0;
            int indexA = 0;
            for (int j = i; j < i + A.length(); j++) {
                if (A.charAt(indexA++) != B.charAt(j)) {
                    diff++;
                }
            }
            answer = Math.min(answer, diff);
        }
        System.out.println(answer);
    }
}
