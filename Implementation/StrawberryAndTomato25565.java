import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StrawberryAndTomato25565 {
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String[] width = new String[N];
        String[] height = new String[M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            width[i] = s.replaceAll(" ", "");
        }
        for (int i = 0; i < M; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(width[j].charAt(i));
            }
            height[i] = sb.toString();
        }

        String goal = "1".repeat(K);
        String check = "2".repeat(K);
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (width[i].contains(goal)) {
                count++;
                width[i] = width[i].replaceFirst(goal, check);
            }
        }
        if (count == 2) {
            System.out.println(0);
            return;
        }
        if (count == 1) { //가로 2개 or 가로1개 세로1개
            for (int i = 0; i < M; i++) {
                if (height[i].contains(goal)) {
                    count++;
                    height[i] = height[i].replaceFirst(goal, check);
                }
            }
            if (count == 2) { // 가로1개 세로1개
                int[][] arr = new int[N][M];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        arr[i][j] += width[i].charAt(j) - '0';
                    }
                }

                for (int j = 0; j < M; j++) {
                    for (int i = 0; i < N; i++) {
                        arr[i][j] += height[j].charAt(i) - '0';
                    }
                }
                StringBuilder sb = new StringBuilder();
                int answer = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (arr[i][j] == 4) {
                            answer++;
                            sb.append(i + 1).append(" ").append(j + 1).append('\n');
                        }
                    }
                }
                System.out.println(answer);
                System.out.print(sb);
                return;
            } else { //가로2개
                int idx = 0;
                for (String s : width) {
                    idx++;
                    if (s.contains(check)) {
                        if (s.contains(goal)) {
                            System.out.println(0);
                            return;
                        }
                        int len = 0;
                        for (int i = 0; i < s.length(); i++) {
                            if (s.charAt(i) == '1') {
                                len++;
                            }
                        }
                        int answer = K - len;
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < s.length(); i++) {
                            if (len == 0) {
                                if (s.charAt(i) != '1') {
                                    if (s.charAt(i) == '0') continue;
                                    sb.append(idx).append(" ").append(i + 1).append('\n');
                                } else {
                                    break;
                                }
                            } else {
                                if (s.charAt(i) == '2') {
                                    len--;
                                }
                            }

                        }
                        System.out.println(answer);
                        System.out.print(sb);
                        return;
                    }
                }
            }
            return;
        }
        // 세로 2개
        for (int i = 0; i < M; i++) {
            if (height[i].contains(goal)) {
                count++;
                height[i] = height[i].replaceFirst(goal, check);
            }
        }
        if (count == 2) {
            System.out.println(0);
            return;
        }

        int idx = 0;
        for (String s : height) {
            idx++;
            if (s.contains(check)) {
                if (s.contains(goal)) {
                    System.out.println(0);
                    return;
                }
                int len = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '1') {
                        len++;
                    }
                }
                int answer = K - len;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (len == 0) {
                        if (s.charAt(i) != '1') {
                            if (s.charAt(i) == '0') {
                                continue;
                            }
                            sb.append(i + 1).append(" ").append(idx).append('\n');
                        } else {
                            break;
                        }
                    } else {
                        if (s.charAt(i) == '2') {
                            len--;
                        }
                    }

                }
                System.out.println(answer);
                System.out.print(sb);
                return;
            }
        }
    }
}
