import java.util.*;

public class PickUpItem {
    static boolean[][] arr;
//    static int[] dx = {0, 0, 1, -1};
//    static int[] dy = {1, -1, 0, 0};
//    static int[] checkX = {1, 1, -1, -1};
//    static int[] checkY = {1, -1, 1, -1};

    // 상하좌우 대각선
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
//        int[][] rectangle = {{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}};
//        int[][] rectangle = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }

    private static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        arr = new boolean[102][102];
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        for (int[] ints : rectangle) {
            for (int i = ints[0] * 2; i <= ints[2] * 2; i++) {
                for (int j = ints[1] * 2; j <= ints[3] * 2; j++) {
                    arr[i][j] = true;
                }
            }
        }
        List<Node> list = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            loop:
            for (int j = 1; j < 100; j++) {
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (!arr[nx][ny]) {
                        continue loop;
                    }
                }
                list.add(new Node(i,j));
            }
        }
        for (Node node : list) {
            arr[node.x][node.y] = false;
        }

        Node start = new Node(characterX, characterY, 0);
        Node end = new Node(itemX, itemY);
        bfs(start, end);
        return answer;
    }

    private static void bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        boolean[][] visited = new boolean[102][102];
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c.equals(end)) {
                answer = Math.min(answer, c.cnt / 2);
            }
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx > 0 && nx <= 100 && ny > 0 && ny <= 100 && !visited[nx][ny] && arr[nx][ny]) {
                    flag = true;
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, c.cnt + 1));
                }
            }

            // 상하좌우로 못갔으면 대각선선
           if (!flag) {
                for (int i = 4; i < 8; i++) {
                    int nx = c.x + dx[i];
                    int ny = c.y + dy[i];
                    if (nx > 0 && nx <= 100 && ny > 0 && ny <= 100 && !visited[nx][ny] && arr[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, c.cnt + 2));
                    }
                }
            }
        }
    }

    private static class Node {
        int x, y, cnt;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
