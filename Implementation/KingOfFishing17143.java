import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KingOfFishing17143 {
    static int R, C, M;
    static Shark[][] arr;
    static int king;
    static int answer;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //상어의 수
        arr = new Shark[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        king = 0;
        answer = 0;
        while (king++ < C) {
            catchShark();
            moveShark();

        }
        System.out.println(answer);

    }

    static void catchShark() {
        for (int i = 1; i <= R; i++) {
            if (arr[i][king] != null) {
                answer += arr[i][king].z;
                arr[i][king] = null;
                break;
            }
        }
    }

    static void moveShark() {
        Shark[][] temp = new Shark[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (arr[i][j] != null) {
                    Shark current = arr[i][j];
                    int x = i;
                    int y = j;
                    int s = current.s;
                    if (current.d == 1 || current.d == 2) { //위 아래
                        if (s >= R * 2 - 2) {
                            s = s % (R * 2 - 2);
                        }
                    } else {
                        if (s >= C * 2 - 2) {
                            s = s % (C * 2 - 2);
                        }
                    }
                    for (int k = 0; k < s; k++) {
                        if (current.d == 1 || current.d == 2) {
                            if (x == 1) {
                                current.d = 2;
                            } else if (x == R) {
                                current.d = 1;
                            }
                            x += dr[current.d];
                        } else {
                            if (y == 1) {
                                current.d = 3;
                            } else if (y == C) {
                                current.d = 4;
                            }
                            y += dc[current.d];
                        }
                    }
                    if (temp[x][y] != null) {
                        if (temp[x][y].z < current.z) {
                            temp[x][y] = current;
                        }
                    } else {
                        temp[x][y] = current;
                    }
                }
            }
        }
        for (int i = 1; i <= R; i++) {
            if (C >= 0) System.arraycopy(temp[i], 1, arr[i], 1, C);
        }
//        for (Shark[] sharks : arr) {
//            for (Shark shark : sharks) {
//                if(shark == null) {
//                    System.out.print(0+" ");
//                } else
//                    System.out.print(shark.z+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("========================");
    }

    static class Shark {
        int s, d, z;

        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }
}
