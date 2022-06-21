import java.util.*;

public class CardMatching {
    static int answer = 1000000;
    static Map<Integer, List<Node>> map;

    public static void main(String[] args) {
//        int[][] board = {{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};
//        int[][] board = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
        int[][] board = {{1, 5, 0, 2}, {6, 4, 3, 0}, {0, 2, 1, 5}, {3, 0, 6, 4}};
        int r = 0;
        int c = 0;
        System.out.println(solution(board, r, c));
    }

    private static int solution(int[][] board, int r, int c) {
        map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) continue;

                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], new ArrayList<>());
                }
                map.get(board[i][j]).add(new Node(i, j));
            }
        }

        int[] arr = new int[map.size()];
        int idx = 0;
        for (Integer num : map.keySet()) {
            arr[idx++] = num;
        }
        int n = map.size();
        permutation(arr, new boolean[n], 0, n, new int[n], board, r, c);
        return answer;

    }

    private static void permutation(int[] arr, boolean[] visited, int depth, int n, int[] output, int[][] board, int r, int c) {
        if (depth == n) {
            System.out.println(Arrays.toString(output));
            solve(board, r, c, output);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[depth] = arr[i];
            permutation(arr, visited, depth + 1, n, output, board, r, c);
            visited[i] = false;
        }
    }

    private static void solve(int[][] board, int sr, int sc, int[] output) {
        // 1 > 2 > 3
        // s > 1
        // 1 > 1
        // 1 > 2
        int n = 1 << output.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int[][] arr = new int[4][4];
            for (int k = 0; k < 4; k++) {
                System.arraycopy(board[k], 0, arr[k], 0, 4);
            }
            int r = sr;
            int c = sc;
            for (int j = 0; j < output.length; j++) {
                int key = output[j];
                int seqCheck = (int) Math.pow(2, j);
                if ((i & seqCheck) > 0) { // 1 0
                    count += getDistance(arr, new Node(r, c), map.get(key).get(1));
                    r = map.get(key).get(1).r;
                    c = map.get(key).get(1).c;
                    arr[r][c] = 0;
                    count += getDistance(arr, new Node(r, c), map.get(key).get(0));
                    r = map.get(key).get(0).r;
                    c = map.get(key).get(0).c;
                    arr[r][c] = 0;
                } else { // 0 1
                    count += getDistance(arr, new Node(r, c), map.get(key).get(0));
                    r = map.get(key).get(0).r;
                    c = map.get(key).get(0).c;
                    arr[r][c] = 0;
                    count += getDistance(arr, new Node(r, c), map.get(key).get(1));
                    r = map.get(key).get(1).r;
                    c = map.get(key).get(1).c;
                    arr[r][c] = 0;
                }
            }
            answer = Math.min(answer, count);
        }
    }

    private static int getDistance(int[][] arr, Node start, Node end) {
        //row 가고 col 감
        int count = 0;
        int k = 1;
        if (start.c > end.c) k = -1;
        int blankCnt = 0;
        for (int i = start.c + k; (k == 1 && i <= end.c) || (k == -1 && i >= end.c); i += k) {
            if (arr[start.r][i] != 0) {
                count++;
            } else {
                blankCnt++;
            }
        }
        if (start.c != end.c && arr[start.r][end.c] == 0) {
            if (end.c == 3 || end.c == 0) {
                count += 1;
            } else {
                count += blankCnt;
            }
        }

        k = 1;
        if (start.r > end.r) k = -1;
        for (int i = start.r + k; (k == 1 && i <= end.r) || (k == -1 && i >= end.r); i += k) {
            if (arr[i][end.c] != 0) {
                count++;
            }
        }

        //col 가고 row 감
        int count2 = 0;
        k = 1;
        blankCnt = 0;
        if (start.r > end.r) k = -1;
        for (int i = start.r + k; (k == 1 && i <= end.r) || (k == -1 && i >= end.r); i += k) {
            if (arr[i][start.c] != 0) {
                count2++;
            } else {
                blankCnt++;
            }
        }
        if (start.r != end.r && arr[end.r][start.c] == 0) {
            if (end.r == 3 || end.r == 0) { // 마지막이 테두리면 1만 더함.
                count2 += 1;
            } else { // 테두가리가 아니면 빈칸 이동한만큼 더함.
                count2 += blankCnt;
            }
        }

        k = 1;
        if (start.c > end.c) k = -1;
        for (int i = start.c + k; (k == 1 && i <= end.c) || (k == -1 && i >= end.c); i += k) {
            if (arr[end.r][i] != 0) {
                count2++;
            }
        }
        return Math.min(count, count2) + 1; // enter 버튼 1추가
    }

    private static class Node {
        int r, c;

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
