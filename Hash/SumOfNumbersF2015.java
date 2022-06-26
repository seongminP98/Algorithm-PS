import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SumOfNumbersF2015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        Map<Long, Long> map = new HashMap<>();
        long answer = 0;
        map.put(0L, 1L);
        while (N-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            long num2 = sum - K;
            if (map.containsKey(num2)) {
                answer += map.get(num2);
            } else if(num == K) {
                answer++;
            }
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }
        System.out.println(answer);
    }
}
