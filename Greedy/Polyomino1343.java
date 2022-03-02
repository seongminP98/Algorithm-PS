import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Polyomino1343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        StringTokenizer stX = new StringTokenizer(str, ".");
        StringTokenizer stD = new StringTokenizer(str, "X");
        if (str.charAt(0) == '.') {
            String dot = stD.nextToken();
            sb.append(".".repeat(dot.length()));
        }
        while (stX.hasMoreTokens()) {
            String next = stX.nextToken();
            String dot = "";
            if (stD.hasMoreTokens()) {
                dot = stD.nextToken();
            }
            int a = next.length() / 4;
            int b = next.length() % 4;
            if (b != 2 && b != 0) {
                System.out.println(-1);
                System.exit(0);
            }
            sb.append("A".repeat(a * 4));
            sb.append("B".repeat(b));
            sb.append(".".repeat(dot.length()));
        }
        System.out.print(sb);
    }
}
