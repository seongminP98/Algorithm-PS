import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RollTheDiceT23288 {
    static int N, M, K;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dy = {1, 0, -1, 0}; // 시계방향 + / 반시계 방향 -
    static int[] dice = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Node node = new Node(0, 0, 0);
        int answer = 0;
        while (K-- > 0) {
            move(node);
            answer += getScore(node);
            changeDir(node);
        }
        System.out.println(answer);

    }

    private static void move(Node node) { // 1번
        int nx = node.x + dx[node.dir];
        int ny = node.y + dy[node.dir];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            node.dir = (node.dir + 2) % 4;
            nx = node.x + dx[node.dir];
            ny = node.y + dy[node.dir];
        }
        node.x = nx;
        node.y = ny;

        int[] nextDice = new int[6];
        if (node.dir == 0) { // 우
            nextDice[0] = dice[3];
            nextDice[1] = dice[1];
            nextDice[2] = dice[0];
            nextDice[3] = dice[5];
            nextDice[4] = dice[4];
            nextDice[5] = dice[2];
        } else if (node.dir == 1) { // 하
            nextDice[0] = dice[1];
            nextDice[1] = dice[5];
            nextDice[2] = dice[2];
            nextDice[3] = dice[3];
            nextDice[4] = dice[0];
            nextDice[5] = dice[4];
        } else if (node.dir == 2) { // 좌
            nextDice[0] = dice[2];
            nextDice[1] = dice[1];
            nextDice[2] = dice[5];
            nextDice[3] = dice[0];
            nextDice[4] = dice[4];
            nextDice[5] = dice[3];
        } else if (node.dir == 3) { // 상
            nextDice[0] = dice[4];
            nextDice[1] = dice[0];
            nextDice[2] = dice[2];
            nextDice[3] = dice[3];
            nextDice[4] = dice[5];
            nextDice[5] = dice[1];
        }
        System.arraycopy(nextDice, 0, dice, 0, 6);
    }

    private static int getScore(Node node) { // 2번
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int num = arr[node.x][node.y];
        int count = 1;
        boolean[][] visited = new boolean[N][M];
        visited[node.x][node.y] = true;
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] == num) {
                    q.add(new Node(nx, ny, c.dir));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count * num;
    }

    private static void changeDir(Node node) { // 3번
        int A = dice[5];
        int B = arr[node.x][node.y];
        if (A > B) {
            node.dir = (node.dir + 1) % 4;
        } else if (A < B) {
            node.dir -= 1;
            if (node.dir == -1) {
                node.dir = 3;
            }
        }
    }

    private static class Node {
        int x, y, dir;

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    '}';
        }

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
