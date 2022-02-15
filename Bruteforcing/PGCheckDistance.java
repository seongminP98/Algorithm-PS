import java.util.ArrayList;
import java.util.List;

public class PGCheckDistance {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = new int[5];
        char[][] arr = new char[5][5];
        for (int t = 0; t < 5; t++) {
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = places[t][i].charAt(j);
                    if (arr[i][j] == 'P') {
                        list.add(new Node(i, j));
                    }
                }
            }
            if (check(arr, list)) {
                answer[t] = 1;
            }
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static boolean check(char[][] arr, List<Node> list) {
        if (list.size() <= 1) {
            return true;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (distance(list.get(i), list.get(j))) {
                    continue;
                }
                //거리 안지켜짐
                if (!partition(list.get(i), list.get(j), arr)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean distance(Node p1, Node p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) > 2;
    }

    static boolean partition(Node p1, Node p2, char[][] arr) {
        if (Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) == 1) {
            return false;
        }
        if (p1.x == p2.x) { //상하
            int y = (p2.y + p1.y) / 2;
            if (arr[p1.x][y] == 'X') {
                return true;
            }
        }
        if (p1.y == p2.y) { //좌우
            int x = (p2.x + p1.x) / 2;
            if (arr[x][p1.y] == 'X') {
                return true;
            }
        }
        if (arr[p1.x][p2.y] == 'X' && arr[p2.x][p1.y] == 'X') {
            return true;
        }
        return false;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
