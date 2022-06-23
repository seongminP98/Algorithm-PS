import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StoneGroup12886 {
    static Set<String> visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start.append(arr[i]);
        }

        q = new LinkedList<>();
        q.add(arr);
        visited = new HashSet<>();
        visited.add(start.toString());
        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (check(c)) {
                System.out.println(1);
                System.exit(0);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (c[i] == c[j]) continue;

                    if (c[i] > c[j] && c[i] - c[j] >= 0) { // i가 큼 Y
                        int remainIdx = 3 - (i + j);
                        int xx = c[j] + c[j];
                        int xy = c[i] - c[j];
                        StringBuilder sb = new StringBuilder();
                        sb.append(arr[remainIdx]).append(xx).append(xy);
                        if (!visited.contains(sb.toString())) {
                            visited.add(sb.toString());
                            int[] next = {c[remainIdx], xx, xy};
                            q.add(next);
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean check(int[] arr) {
        return arr[0] == arr[1] && arr[1] == arr[2];
    }
}
