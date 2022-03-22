import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 3가지 케이스로 나눠야함.
 * N==1 / N%4==1 / N%4==3
 * 처음에 T.C만 보고 2가지 케이스로 나눴다가 틀림.
 * 반례 :
 * OO.
 * OOO
 * OOO
 */
public class Bomberman16918 {
    static int R, C, N;
    static char[][] arr;
    static char[][] arr2;
    static char[][] arr3;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'O') {
                    list.add(new Node(i, j));
                }
            }
        }
        arr2 = new char[R][C];
        arr3 = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr2[i][j] = 'O';
                arr3[i][j] = 'O';
            }
        }
        for (Node node : list) {
            arr2[node.x][node.y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    arr2[nx][ny] = '.';
                }
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr2[i][j] == 'O') {
                    list.add(new Node(i, j));
                }
            }
        }
        for (Node node : list) {
            arr3[node.x][node.y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    arr3[nx][ny] = '.';
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        if (N == 1) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append('\n');
            }
        } else if (N % 2 == 0) {
            for (int i = 0; i < R; i++) {
                sb.append("O".repeat(Math.max(0, C)));
                sb.append('\n');
            }
        } else {
            if (N % 4 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        sb.append(arr3[i][j]);
                    }
                    sb.append('\n');
                }
            } else { //N%4==3
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        sb.append(arr2[i][j]);
                    }
                    sb.append('\n');
                }
            }
        }
        System.out.print(sb);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
