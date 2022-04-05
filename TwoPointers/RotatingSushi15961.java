import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RotatingSushi15961 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        map.put(c, map.getOrDefault(c, 0) + 1);
        int answer = map.size();
        int start = 0;
        while (start < N) {
            int end = (start + k) % N;
            map.put(arr[start], map.getOrDefault(arr[start], 2) - 1);
            if (map.get(arr[start]) == 0) {
                map.remove(arr[start]);
            }
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            if (map.size() > answer) answer = map.size();

            start++;
        }
        System.out.println(answer);
    }
}
