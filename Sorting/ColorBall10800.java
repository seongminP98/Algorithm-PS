import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ColorBall10800 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ColorBall[] arr = new ColorBall[N];
        Map<Integer, Integer> colorMap = new HashMap<>();
        int sumSize = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            arr[i] = new ColorBall(i, color, size);
            sumSize += size;
            colorMap.put(color, colorMap.getOrDefault(color, 0) + size);
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2.size, o1.size)); // 크기 순 내림차순 정렬

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int sameSize = 0;
            for (int j = i + 1; j < N; j++) {
                if (arr[i].size == arr[j].size) {
                    if (arr[i].color != arr[j].color) {
                        sameSize++;
                    }
                } else {
                    break;
                }
            }
            sumSize -= arr[i].size;
            colorMap.put(arr[i].color, colorMap.get(arr[i].color) - arr[i].size);
            answer[arr[i].num] = sumSize - colorMap.get(arr[i].color) - (sameSize * arr[i].size);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }

    private static class ColorBall {
        int num, color, size;

        public ColorBall(int num, int color, int size) {
            this.num = num;
            this.color = color;
            this.size = size;
        }
    }
}
