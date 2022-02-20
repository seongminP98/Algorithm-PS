import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HitBalloon11509 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(Integer.parseInt(st.nextToken()));

        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (list.contains(next + 1)) {
                list.remove(Integer.valueOf(next + 1));
            }
            list.add(next);
        }
        System.out.println(list.size());

    }
}
/* 이게 시간 훨씬 빠름. 다른사람이 푼 코드
public class HitBalloon11509 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[1_000_002];
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (arr[height + 1] != 0) {
                arr[height + 1]--;
                arr[height]++;
                continue;
            }

            ans++;
            arr[height]++;
        }

        System.out.println(ans);

    }

}
 */