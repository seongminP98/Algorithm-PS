import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Snake3190 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    //우,하,좌,상
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        board[1][1] = -1; //뱀이 있는곳
        Deque<Snake> snake = new ArrayDeque<>();
        snake.offer(new Snake(1,1));

        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Queue<Direction> dir = new LinkedList<>();
        for(int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir.offer(new Direction(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)));
        }

        int answer = 0;
        int x = dir.peek().sec;
        char c = dir.poll().d;

        int snakeDir = 0; //처음엔 오른쪽 방향
        while(true) {
            answer++;
            int nx = snake.peekFirst().x + dx[snakeDir];
            int ny = snake.peekFirst().y + dy[snakeDir];

            if(nx<1 || nx>=(N+1) || ny<1 || ny>=(N+1) || board[nx][ny] == -1) {
                break;
            }

            if(board[nx][ny] == 1) { //사과가있으면 머리추가
                snake.offerFirst(new Snake(nx,ny));
                board[nx][ny] = -1;
            } else { //사과가 없으면 머리추가, 꼬리삭제
                snake.offerFirst(new Snake(nx,ny));
                board[snake.peekLast().x][snake.pollLast().y] = 0;
                board[nx][ny] = -1;
            }

            //우,하,좌,상
            if(answer == x) {
                if(c == 'D') { //오른쪽으로 돌림.
                    if(snakeDir == 3) {
                        snakeDir=0;
                    }else{
                        snakeDir++;
                    }
                } else { //왼쪽으로 돌림
                   if(snakeDir == 0) {
                       snakeDir=3;
                   }else {
                       snakeDir--;
                   }
                }
                if(!dir.isEmpty()) {
                    x = dir.peek().sec;
                    c = dir.poll().d;
                }
            }
        }
        System.out.println(answer);
    }
    static class Direction{
        int sec;
        char d;

        public Direction(int sec, char d) {
            this.sec = sec;
            this.d = d;
        }
    }
    static class Snake{
        int x,y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
