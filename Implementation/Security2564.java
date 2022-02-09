import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Security2564 {
    static int W, L, N;
    static int dongDir, dongDis; //동근이 위치

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        //1: 북, 2: 남, 3: 서, 4:동
        Store[] stores = new Store[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i] = new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        dongDir = Integer.parseInt(st.nextToken());
        dongDis = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += minDistance(stores[i].dir, stores[i].dis);
        }
        System.out.println(answer);
    }

    static int minDistance(int dir, int dis) {
        if (dir == dongDir) {
            return Math.abs(dis - dongDis);
        }
        if (dongDir == 1) {
            if (dir == 2) {
                return Math.min(dis + dongDis, W - dis + W - dongDis) + L;
            } else if (dir == 3) {
                return dis + dongDis;
            } else if (dir == 4) {
                return W - dongDis + dis;
            }
        } else if (dongDir == 2) {
            if (dir == 1) {
                return Math.min(dis + dongDis, W - dis + W - dongDis) + L;
            } else if (dir == 3) {
                return dongDis + L - dis;
            } else if (dir == 4) {
                return W - dongDis + L - dis;
            }
        } else if (dongDir == 3) {
            if (dir == 1) {
                return dongDis + dis;
            } else if (dir == 2) {
                return L - dongDis + dis;
            } else if (dir == 4) {
                return Math.min(dis + dongDis, L - dis + L - dongDis) + W;
            }
        } else if (dongDir == 4) {
            if (dir == 1) {
                return dongDis + W - dis;
            } else if (dir == 2) {
                return L - dongDis + W - dis;
            } else if (dir == 3) {
                return Math.min(dis + dongDis, L - dis + L - dongDis) + W;
            }
        }
        return 0;
    }

    static class Store {
        int dir, dis;

        public Store(int dir, int dis) {
            this.dir = dir;
            this.dis = dis;
        }
    }
}
