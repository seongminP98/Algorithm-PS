import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Turtle8911 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] directX = {0, 1, 0, -1}; //북,동,남,서
        int[] directY = {1, 0, -1, 0}; //북,동,남,서
        for (int t = 0; t < T; t++) {
            int d = 0;
            int minX = 0;
            int minY = 0;
            int maxX = 0;
            int maxY = 0;
            int cX = 0;
            int cY = 0;
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'F') {
                    cX = cX + directX[d];
                    cY = cY + directY[d];
                }
                if (str.charAt(i) == 'B') {
                    cX = cX - directX[d];
                    cY = cY - directY[d];
                }
                if (str.charAt(i) == 'L') {
                    if (d == 0) {
                        d = 3;
                    } else {
                        d--;
                    }
                }
                if (str.charAt(i) == 'R') {
                    if (d == 3) {
                        d = 0;
                    } else {
                        d++;
                    }
                }
                maxX = Math.max(maxX, cX);
                maxY = Math.max(maxY, cY);
                minX = Math.min(minX, cX);
                minY = Math.min(minY, cY);
            }
            sb.append((maxX - minX) * (maxY - minY)).append('\n');
        }
        System.out.print(sb);
    }
}
