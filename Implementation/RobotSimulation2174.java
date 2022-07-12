import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotSimulation2174 {
    static int A, B, N, M;
    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0}; // E, S, W, N     여기에 +1
    static Robot[] robots;
    static int crashRobot = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // 가로
        B = Integer.parseInt(st.nextToken()); // 세로
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 로봇의 개수
        M = Integer.parseInt(st.nextToken()); // 명령 개수
        robots = new Robot[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int d;
            switch (dir) {
                case "E":
                    d = 1;
                    break;
                case "S":
                    d = 2;
                    break;
                case "W":
                    d = 3;
                    break;
                default:
                    d = 0;
                    break;
            }
            robots[i] = new Robot(x, y, d);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNum = Integer.parseInt(st.nextToken());
            String cmd = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            if (cmd.equals("F")) {
                simulationF(robotNum, cnt);
            } else if (cmd.equals("R")) {
                simulationR(robotNum, cnt);
            } else {
                simulationL(robotNum, cnt);
            }
        }
        System.out.println("OK");

    }

    private static void simulationF(int robotNum, int cnt) {
        while (cnt-- > 0) {
            robots[robotNum].x += dx[robots[robotNum].d];
            robots[robotNum].y += dy[robots[robotNum].d];
            if (isOut(robots[robotNum])) {
                System.out.printf("Robot %d crashes into the wall", robotNum);
                System.exit(0);
            }
            if (isCrash(robots[robotNum])) {
                System.out.printf("Robot %d crashes into robot %d", robotNum, crashRobot);
                System.exit(0);
            }
        }
    }

    private static void simulationR(int robotNum, int cnt) {
        cnt %= 4;
        while (cnt-- > 0) {
            robots[robotNum].d++;
            robots[robotNum].d %= 4;
        }
    }

    private static void simulationL(int robotNum, int cnt) {
        cnt %= 4;
        while (cnt-- > 0) {
            robots[robotNum].d--;
            if (robots[robotNum].d == -1) {
                robots[robotNum].d = 3;
            }
        }
    }

    private static boolean isOut(Robot r) {
        return r.x < 1 || r.x > A || r.y < 1 || r.y > B;
    }

    private static boolean isCrash(Robot r) {
        for (int i = 1; i <= N; i++) {
            if (r == robots[i]) continue;
            if (r.x == robots[i].x && r.y == robots[i].y) {
                crashRobot = i;
                return true;
            }
        }
        return false;
    }

    private static class Robot {
        int x, y, d;

        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
