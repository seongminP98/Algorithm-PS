import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SemiconductorDesign2352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(N + 1);
        list.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = list.size() - 1;
            if (list.get(right) < num) {
                list.add(num);
                continue;
            }
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            list.set(left, num);
        }
        System.out.println(list.size() - 1);
    }
}
