import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaskinrobbinsN {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println((Long.parseLong(st.nextToken()) - 1) % (Long.parseLong(st.nextToken()) + 1) == 0 ? "Can't win" : "Can win");
    }
}
