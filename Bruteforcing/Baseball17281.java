import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baseball17281 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int[] player;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[9];
        player = new int[9];
        visited[3] = true;
        player[3] = 0;

        answer = 0;
        permutation(1);
        System.out.println(answer);

    }

    static void permutation(int count) {
        if (count == 9) {
            game();
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                player[i] = count;
                permutation(count + 1);
                visited[i] = false;
            }
        }
    }

    static void game() {

        int score = 0;
        int playerNum = 0;

        for (int i = 0; i < N; i++) { //이닝

            List<Integer> ru = new ArrayList<>();
            int out = 0;
            while (out < 3) {
                int result = arr[i][player[playerNum % 9]];
                if (result == 0) {
                    out++;
                } else {
                    if (result == 4) {
                        score += (ru.size() + 1);
                        ru.clear();
                    } else {

                        for (int j = 0; j < ru.size(); j++) {
                            if (ru.get(j) + result > 3) {
                                ru.remove(j--);
                                score++;
                            } else {
                                ru.set(j, ru.get(j) + result);
                            }
                        }
                        ru.add(result);
                    }
                }
                playerNum++;
            }
        }
        answer = Math.max(answer, score);
    }
}
