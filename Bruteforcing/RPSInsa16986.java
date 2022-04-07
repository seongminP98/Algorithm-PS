import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RPSInsa16986 {
    static int N, K;
    static List<Set<Integer>> win;
    static int[] KH, MH;
    static int count;
    static int[] score;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        win = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            win.add(new HashSet<>());
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("2")) {
                    win.get(i).add(j);
                }
            }
        }
        KH = new int[20];
        MH = new int[20];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            KH[i] = Integer.parseInt(st.nextToken());
            MH[i] = Integer.parseInt(st2.nextToken());
        }
        count = 3 * K - 2;
        permutation(0, new int[N], new boolean[N + 1]);
        System.out.println(0);
    }

    static void permutation(int depth, int[] JW, boolean[] visited) {
        if (depth == N) { //이 안에 코드를 따로 메서드를 만들었지만, 재귀함수 안에서 또다른 함수를 호출하면 그것까지 다 스택에 쌓이기 때문에 시간차이가 남.
            int front = 0;
            int back = 1;
            int idx = 0; //지우가 낼 손동작
            int idxK = 0; //경희가 낼 손동작
            int idxM = 0; //민호가 낼 손동작
            score = new int[3];
            for (int i = 0; i < count; i++) {
                int winner;
                if (front == 0) {
                    if (back == 1) {
                        winner = match(front, back, JW[idx++], KH[idxK++]);
                        back = 2;
                    } else { //민호
                        winner = match(front, back, JW[idx++], MH[idxM++]);
                        back = 1;
                    }
                } else if (front == 1) {
                    if (back == 0) {
                        winner = match(front, back, KH[idxK++], JW[idx++]);
                        back = 2;
                    } else { // 민호
                        winner = match(front, back, KH[idxK++], MH[idxM++]);
                        back = 0;
                    }
                } else { // 민호
                    if (back == 1) {
                        winner = match(front, back, MH[idxM++], KH[idxK++]);
                        back = 0;
                    } else { // 지우
                        winner = match(front, back, MH[idxM++], JW[idx++]);
                        back = 1;
                    }
                }
                score[winner]++;
                front = winner;
                if (score[1] == K || score[2] == K) {
                    break;
                }
                if (score[0] == K) {
                    System.out.println(1);
                    System.exit(0);
                }
                if (idx >= N) {
                    break;
                }
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                JW[depth] = i;
                permutation(depth + 1, JW, visited);
                visited[i] = false;
            }
        }
    }

    static int match(int front, int back, int frontHand, int backHand) {
        if (frontHand == backHand) {
            return Math.max(front, back);
        } else if (win.get(backHand).contains(frontHand)) {
            return back;
        } else {
            return front;
        }
    }
}
