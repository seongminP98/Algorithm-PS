import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Emoticon14226 {
    static int S;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[1050][1050]; //화면, 클립보드 방문처리 / 화면만 방문처리하면 틀림
        bfs();
    }

    static void bfs() {
        Queue<Emoticon> q = new LinkedList<>();
        q.add(new Emoticon(1, 0, 0));
        while (!q.isEmpty()) {

            int screen = q.peek().screen;
            int time = q.peek().time;
            int board = q.poll().board;
            visited[screen][board] = true;

            if (screen == S) {
                System.out.println(time);
                return;
            }

            if (screen != board && !visited[screen][screen]) { //1번
                q.add(new Emoticon(screen, screen, time + 1));
            }
            if (screen + board < 1050 && !visited[screen + board][board]) { //2번
                q.add(new Emoticon(screen + board, board, time + 1));
            }
            if (screen - 1 > 0 && !visited[screen - 1][board]) { //3번
                q.add(new Emoticon(screen - 1, board, time + 1));
            }
        }
    }

    static class Emoticon {
        int screen, board, time;

        public Emoticon(int screen, int board, int time) {
            this.screen = screen;
            this.board = board;
            this.time = time;
        }
    }
}
