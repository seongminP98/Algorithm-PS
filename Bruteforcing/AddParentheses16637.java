import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AddParentheses16637 {
    static int N;
    static List<Integer> num = new LinkedList<>();
    static List<Character> op = new LinkedList<>();
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        if (N == 1) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                num.add(s.charAt(i) - '0');
            } else {
                op.add(s.charAt(i));
            }
        }
        visited = new boolean[N / 2];
        powerSet(N / 2, 1);
        System.out.println(answer);

    }

    static void powerSet(int n, int idx) {
        if (idx == n) {
            answer = Math.max(answer, solution());
            return;
        }
        if (visited[idx - 1]) {
            visited[idx] = false;
            powerSet(n, idx + 1);
        } else {
            visited[idx] = false;
            powerSet(n, idx + 1);
            visited[idx] = true;
            powerSet(n, idx + 1);
        }
    }

    static int solution() {
        Deque<Integer> q = new LinkedList<>();
        boolean check = false;
        for (int i = 0; i < N / 2; i++) {
            if (visited[i]) {
                int result = calc(num.get(i), num.get(i + 1), op.get(i));
                i++;
                q.add(result);
                if (i == N / 2) {
                    check = true;
                }
            } else {
                q.add(num.get(i));
            }
        }
        if (!check) {
            q.add(num.get(num.size() - 1));
        }

        for (int i = 0; i < N / 2; i++) {
            if (!visited[i]) {
                int a = q.poll();
                int b = q.poll();
                int result = calc(a, b, op.get(i));
                q.offerFirst(result);
            }
        }

        return q.poll();
    }

    static int calc(int a, int b, char operation) {
        if (operation == '+') {
            return a + b;
        } else if (operation == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}
