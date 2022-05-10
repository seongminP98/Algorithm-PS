import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class DiceYutGame17825 {
    static int[] dice;
    static Map<Integer, int[]> routes = new HashMap<>();
    static Yut[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dice = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        arr = new Yut[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = new Yut(0, 0, 0, 0, false, false);
        }
        routes.put(1, new int[]{10, 13, 16, 19, 25, 30, 35, 40});
        routes.put(2, new int[]{20, 22, 24, 25, 30, 35, 40});
        routes.put(3, new int[]{30, 28, 27, 26, 25, 30, 35, 40});
        dfs(0);
        System.out.println(answer);
    }
    private static void dfs(int depth) {
        if (depth == 10) {
            int sum = 0;
            for (Yut yut : arr) {
                sum += yut.sumScore;
            }
            if (sum > answer) answer = sum;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].goal) continue;

            int sumScore = arr[i].sumScore;
            int cScore = arr[i].cScore;
            int route = arr[i].route;
            int routeIdx = arr[i].routeIdx;
            boolean goal = arr[i].goal;
            boolean lastLoad = arr[i].lastLoad;

            if (arr[i].route == 0) {
                int nextScore = arr[i].cScore + 2 * dice[depth];
                if (nextScore == 10) {
                    arr[i].route = 1;
                } else if (nextScore == 20) {
                    arr[i].route = 2;
                } else if (nextScore == 30) {
                    arr[i].route = 3;
                } else if (nextScore == 40) {
                    arr[i].lastLoad = true;
                } else if (nextScore > 40) {
                    arr[i].goal = true;
                }
                if (!arr[i].goal) {
                    arr[i].cScore = nextScore;
                    arr[i].sumScore += nextScore;
                }
            } else {
                int nextIdx = arr[i].routeIdx + dice[depth];
                if (arr[i].route == 2 && nextIdx >= 7) {
                    arr[i].goal = true;
                } else if (nextIdx >= 8) {
                    arr[i].goal = true;
                } else {
                    arr[i].routeIdx = nextIdx;
                    arr[i].cScore = routes.get(arr[i].route)[arr[i].routeIdx];
                    arr[i].sumScore += arr[i].cScore;
                }
                if (arr[i].route != 3 && arr[i].cScore >= 25) {
                    arr[i].lastLoad = true;
                }
                if (arr[i].route == 3 && arr[i].routeIdx >= 4) {
                    arr[i].lastLoad = true;
                }
            }
            if(!arr[i].goal && !canGo(i)) {
                back(sumScore, cScore, route, routeIdx, i, goal, lastLoad);
                continue;
            }
            dfs(depth + 1);
            back(sumScore, cScore, route, routeIdx, i, goal, lastLoad);
        }
    }

    private static boolean canGo(int idx) {
        for (int i = 0; i < arr.length; i++) {
            if (i == idx) continue;
            if(arr[i].goal) continue;
            if (arr[idx].lastLoad && arr[i].lastLoad) {
                if(arr[idx].cScore == arr[i].cScore) {
                    return false;
                }
            } else {
                if(arr[idx].equals(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void back(int sumScore, int cScore, int route, int routeIdx, int yutIdx, boolean goal, boolean lastLoad) {
        arr[yutIdx].sumScore = sumScore;
        arr[yutIdx].cScore = cScore;
        arr[yutIdx].route = route;
        arr[yutIdx].routeIdx = routeIdx;
        arr[yutIdx].goal = goal;
        arr[yutIdx].lastLoad = lastLoad;
    }

    private static class Yut {
        int sumScore, cScore, route, routeIdx;
        boolean goal, lastLoad;

        @Override
        public String toString() {
            return "Yut{" +
                    "sumScore=" + sumScore +
                    ", cScore=" + cScore +
                    ", route=" + route +
                    ", routeIdx=" + routeIdx +
                    ", goal=" + goal +
                    ", lastLoad=" + lastLoad +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Yut yut = (Yut) o;
            return cScore == yut.cScore &&
                    route == yut.route &&
                    routeIdx == yut.routeIdx &&
                    goal == yut.goal &&
                    lastLoad == yut.lastLoad;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cScore, route, routeIdx, goal, lastLoad);
        }

        public Yut(int sumScore, int cScore, int route, int routeIdx, boolean goal, boolean lastLoad) {
            this.sumScore = sumScore;
            this.cScore = cScore;
            this.route = route;
            this.routeIdx = routeIdx;
            this.goal = goal;
            this.lastLoad = lastLoad;
        }
    }
}
