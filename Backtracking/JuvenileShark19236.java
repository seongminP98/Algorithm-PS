import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class JuvenileShark19236 {
    static int[][] arr;
    static Fish[] fish;
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[4][4];
        fish = new Fish[17];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;
                fish[num] = new Fish(i, j, num, dir, 1);
                arr[i][j] = num;
            }
        }
        int sx = 0, sy = 0;
        int sd = fish[arr[0][0]].dir;
        int eat = arr[0][0];
        fish[arr[0][0]].alive = 0;
        arr[0][0] = -1; //처음 상어위치

        dfs(sx, sy, sd, eat);
        System.out.println(answer);


    }

    static void dfs(int sx, int sy, int sd, int eat) {
        answer = Math.max(answer, eat);
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, 4);
        }
        Fish[] tempFish = new Fish[fish.length];
        for (int i = 1; i <= 16; i++) {
            tempFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].num, fish[i].dir, fish[i].alive);
        }

        moveFish();

        for (int i = 1; i <= 3; i++) {
            int nx = sx + dx[sd] * i;
            int ny = sy + dy[sd] * i;
            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && arr[nx][ny] != 0) {
                int eatFish = arr[nx][ny];
                int nd = fish[eatFish].dir;
                arr[sx][sy] = 0;
                arr[nx][ny] = -1;
                fish[eatFish].alive = 0;

                dfs(nx, ny, nd, eat + eatFish);

                fish[eatFish].alive = 1;
                arr[sx][sy] = -1;
                arr[nx][ny] = eatFish;
            }
        }
        for (int i = 0; i < 4; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, 4);
        }
        for (int i = 1; i <= 16; i++) {
            fish[i] = new Fish(tempFish[i].x, tempFish[i].y, tempFish[i].num, tempFish[i].dir, tempFish[i].alive);
        }

    }

    static void moveFish() {

        for (int i = 1; i <= 16; i++) {
            if (fish[i].alive == 0)
                continue;

            int cnt = 0;
            int dir = fish[i].dir;
            int nx = 0;
            int ny = 0;
            while(cnt < 8) { //이동할 수 있는 위치를 찾을때까지 45도 방향 바꾸며 반복
                dir %= 8; //방향 +1로 범위 넘어가는 걸 처리하기 위한 나머지 연산
                fish[i].dir = dir; //방향 바꿨다면 바뀐 것 적용

                nx = fish[i].x + dx[dir]; //방향에 맞게 좌표 이동
                ny = fish[i].y + dy[dir];

                //이동할 위치에 상어가 없고, 경계를 넘지 않는다면 이동 가능
                if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && arr[nx][ny] != -1) {
                    if(arr[nx][ny] == 0) { //이동할 위치가 빈칸일 경우
                        arr[fish[i].x][fish[i].y] = 0; //기존 위치 빈칸으로
                        fish[i].x = nx;
                        fish[i].y = ny;
                        arr[nx][ny] = i;
                    } else { //이동할 위치에 다른 물고기가 있을 경우
                        // 바꿀 물고기 위치 변경
                        int changeFish = fish[arr[nx][ny]].num;
                        fish[changeFish].x = fish[i].x;
                        fish[changeFish].y = fish[i].y;
                        arr[fish[changeFish].x][fish[changeFish].y] = changeFish;

                        //현재 물고기 위치 변경
                        fish[i].x = nx;
                        fish[i].y = ny;
                        arr[nx][ny] = i;
                    }
                    break;
                } else {
                    dir++;
                    cnt++;
                }
            }
        }

    }

    static class Fish {
        int x, y, num, dir, alive;

        public Fish(int x, int y, int num, int dir, int alive) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.alive = alive;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "x=" + x +
                    ", y=" + y +
                    ", num=" + num +
                    ", dir=" + dir +
                    ", alive=" + alive +
                    '}';
        }

    }
}
