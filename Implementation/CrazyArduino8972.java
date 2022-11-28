import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CrazyArduino8972 {
    static int R, C;
    static String cmd;
    static Node JS;
    static List<Node> crazyArduino;
    static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        crazyArduino = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'I') {
                    JS = new Node(i, j);
                }
                if (s.charAt(j) == 'R') {
                    crazyArduino.add(new Node(i, j));
                }
            }
        }
        cmd = br.readLine();
        int count = 0;
        for (int i = 0; i < cmd.length(); i++) {
            count++;
            if (!play(cmd.charAt(i) - '0')) {
                System.out.println("kraj " + count);
                return;
            }
        }
        print();


    }

    private static void print() {
        char[][] result = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(result[i], '.');
        }
        result[JS.x][JS.y] = 'I';
        for (Node node : crazyArduino) {
            result[node.x][node.y] = 'R';
        }
        StringBuilder sb = new StringBuilder();
        for (char[] chars : result) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean play(int k) {
        JS.x += dx[k];
        JS.y += dy[k];
        if (JS.isEnd()) {
            return false;
        }
        for (Node node : crazyArduino) {
            if (!node.move()) {
                return false;
            }

        }
        if (JS.isEnd()) {
            return false;
        }
        boom();
        return true;
    }

    private static void boom() {
        Set<Node> set = new HashSet<>();
        for (Node node : crazyArduino) {
            if (!set.add(node)) {
                for (Node node1 : set) {
                    if (node.equals(node1)) {
                        node1.check = true;
                    }
                }
            }
        }
        crazyArduino = new ArrayList<>();
        for (Node node : set) {
            if (!node.check) {
                crazyArduino.add(node);
            }
        }
    }

    private static class Node {
        int x, y;
        boolean check;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", check=" + check +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean isEnd() {
            for (Node node : crazyArduino) {
                if (this.equals(node)) {
                    return true;
                }
            }
            return false;
        }

        public boolean move() {
            if (this.equals(JS)) {
                return false;
            }
            if (this.x == JS.x) {
                if (this.y > JS.y) {
                    this.y--;
                } else {
                    this.y++;
                }
            } else if (this.y == JS.y) {
                if (this.x > JS.x) {
                    this.x--;
                } else {
                    this.x++;
                }
            } else {
                double l = (double) (JS.y - this.y) / (JS.x - this.x);
                if (l > 0) {
                    if (this.x > JS.x) { // 오른쪽 아래
                        this.x--;
                        this.y--;
                    } else { // 왼쪽 위
                        this.x++;
                        this.y++;
                    }
                } else {
                    if (this.x > JS.x) { // 왼쪽 아래
                        this.x--;
                        this.y++;
                    } else { // 오른쪽 위
                        this.x++;
                        this.y--;
                    }
                }
            }
            return true;
        }
    }
}
