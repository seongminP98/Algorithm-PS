import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ShootArrows20157 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            /*
            기울기처럼 x/y로 하면 틀림. 정확하지 않아서 그런듯. 소수점 끝까지 구하는게 아니니..
            atan 하면 틀림. 음수의 경우 atan2 로 해야 더 정확하다고 한다.
             */
            
            double inclination = Math.atan2(x, y);
            map.put(inclination, map.getOrDefault(inclination, 0) + 1);
        }
        int answer = 0;
        for (Integer value : map.values()) {
            answer = Math.max(value, answer);
        }
        System.out.println(answer);
    }
}
