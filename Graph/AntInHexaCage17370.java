import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AntInHexaCage17370 {
    static int N;
    // x가 홀수는 위로 하나 아래로 두개 dx={-1,1,1} dy={0,-1,1}
    // x가 짝수는 위로 두개 아래로 하나 dx={-1,-1,1} dy={-1,1,0}
    static int[] odx = {-1, 1, 1};
    static int[] ody = {0, -1, 1};

    static int[] edx = {-1, -1, 1};
    static int[] edy = {-1, 1, 0};
    static Set<Node> visited;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new HashSet<>();

        // 내가 보기 편하려고 시작을 이렇게 함.
        visited.add(new Node(5, 3));
        visited.add(new Node(4, 3));

        dfs(0, new Node(5, 3), new Node(4, 3));
        System.out.println(answer);
    }

    static void dfs(int cnt, Node before, Node c) {
        if (cnt == N - 1) { // 마지막은 여기서 확인
            for (int i = 0; i < 3; i++) {
                int nx, ny;
                if (c.x % 2 == 0) { //짝수
                    nx = c.x + edx[i];
                    ny = c.y + edy[i];
                } else { //홀수
                    nx = c.x + odx[i];
                    ny = c.y + ody[i];
                }
                if (nx == before.x && ny == before.y) continue;

                Node after = new Node(nx, ny);
                if (visited.contains(after)) {
                    answer++;
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx, ny;
            if (c.x % 2 == 0) { //짝수
                nx = c.x + edx[i];
                ny = c.y + edy[i];
            } else { //홀수
                nx = c.x + odx[i];
                ny = c.y + ody[i];
            }
            if (nx == before.x && ny == before.y) continue;

            Node after = new Node(nx, ny);
            if (!visited.contains(after)) {
                visited.add(after);
                dfs(cnt + 1, c, after);
                visited.remove(after);
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
