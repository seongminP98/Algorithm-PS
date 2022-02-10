import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RoomAssignments13300 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String student = br.readLine();
            hm.put(student, hm.getOrDefault(student, 0) + 1);
        }
        int answer = 0;
        for (Integer value : hm.values()) {
            if (value % K == 0) {
                answer += value / K;
            } else {
                answer += value / K + 1;
            }
        }
        System.out.println(answer);
    }
}
