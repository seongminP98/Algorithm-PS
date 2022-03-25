import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game1072 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()); //게임 횟수
        int Y = Integer.parseInt(st.nextToken()); //이긴 횟수
        int Z = (int) (((long)Y * 100) / X);
        int left = 0;
        int right =  1000000000;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int nextZ = (int) (((long)(Y + mid) * 100) / (X + mid));
            if(Z != nextZ) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        System.out.println(answer);
    }
}
