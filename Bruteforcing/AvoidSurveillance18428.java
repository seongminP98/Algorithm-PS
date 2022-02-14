import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AvoidSurveillance18428 {
    static int N;
    static char[][] arr;
    static List<Node> teachers = new ArrayList<>();
    static List<Node> block = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[] visited;
    static Node[] output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken().charAt(0);
                if (arr[i][j] == 'T') {
                    teachers.add(new Node(i, j));
                }
                if (arr[i][j] == 'X') {
                    block.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[block.size()];
        output = new Node[3];
        combination(3, 0);
        System.out.println("NO");

    }

    static void combination(int depth, int start) {
        if (depth == 0) {
            char[][] hallway = new char[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(arr[i], 0, hallway[i], 0, N);
            }
            for (int i = 0; i < 3; i++) {
                hallway[output[i].x][output[i].y] = 'O';
            }

            if (check(hallway)) {

                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < block.size(); i++) {
            output[depth - 1] = block.get(i);
            combination(depth - 1, i + 1);

        }
    }

    static boolean check(char[][] hallway) {
        for (Node teacher : teachers) {
            for (int k = 0; k < 4; k++) {
                int x = teacher.x;
                int y = teacher.y;

                while (true) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        x = nx;
                        y = ny;
                        if (hallway[x][y] == 'O') {
                            break;
                        }
                        if (hallway[x][y] == 'S') {
                            return false;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
