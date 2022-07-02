import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Drop7 {
    static int initCount = 0;
    static int[][] arr = new int[7][7];
    static int[][] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) initCount++;
            }
        }
        int ball = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < 7; i++) {
            int delCount = solution(i, ball);
            answer = Math.max(answer, delCount);
        }
        System.out.println(initCount + 1 - answer);

    }

    private static int solution(int n, int ball) { // 0<=n<7 , n번 컬럼에 떨굼
        temp = new int[7][7];
        for (int i = 0; i < 7; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, 7);
        }
        boolean check = false;
        for (int i = 1; i < 7; i++) {
            if (temp[i][n] != 0) {
                temp[i - 1][n] = ball;
                check = true;
                break;
            }
        }
        if (!check) {
            temp[6][n] = ball;
        }
        int delCount = 0;
        while (true) {
            Set<Node> set = new HashSet<>();
            for (int i = 0; i < 7; i++) {
                set.addAll(game(i));
            }
            if (set.size() == 0) break;

            for (Node node : set) {
                temp[node.x][node.y] = 0;
                delCount++;
            }
            fallDown();
        }
        return delCount;
    }

    private static Set<Node> game(int n) {
        Set<Node> set = new HashSet<>();
        List<Node> tempCol = new ArrayList<>();
        List<Node> tempRow = new ArrayList<>();
        int countCol = 0;
        int countRow = 0;
        for (int i = 0; i < 7; i++) { // column
            if (temp[i][n] != 0) {
                tempCol.add(new Node(i, n, temp[i][n]));
                countCol++;
            } else {
                if (countCol > 0) {
                    for (Node node : tempCol) {
                        if (node.num == countCol) {
                            set.add(node);
                        }
                    }
                    tempCol = new ArrayList<>();
                    countCol = 0;
                }
            }
            if (temp[n][i] != 0) {
                tempRow.add(new Node(n, i, temp[n][i]));
                countRow++;
            } else {
                if (countRow > 0) {
                    for (Node node : tempRow) {
                        if (node.num == countRow) {
                            set.add(node);
                        }
                    }
                    tempRow = new ArrayList<>();
                    countRow = 0;
                }
            }
        }

        for (Node node : tempCol) {
            if (node.num == countCol) {
                set.add(node);
            }
        }

        for (Node node : tempRow) {
            if (node.num == countRow) {
                set.add(node);
            }
        }
        return set;
    }

    private static void fallDown() {
        for (int i = 6; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                if (temp[i][j] == 0)
                    continue;
                int cnt = 0;
                for (int k = i + 1; k < 7; k++) {
                    if (temp[k][j] == 0) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                if (cnt > 0) {
                    temp[i + cnt][j] = temp[i][j];
                    temp[i][j] = 0;
                }

            }
        }
    }


    static class Node {
        int x, y, num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", num=" + num +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y &&
                    num == node.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, num);
        }
    }
}
