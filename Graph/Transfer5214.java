import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Transfer5214 {
    static int N, K, M;
    static List<List<Integer>> stations, hyperTube;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 역의 수
        K = Integer.parseInt(st.nextToken()); // 서로 연결하는 역의 개수
        M = Integer.parseInt(st.nextToken()); // 하이퍼튜브 개수

        stations = new ArrayList<>(); // 이 역이 어떤 하이퍼튜브와 연결되어 있는지 저장.
        hyperTube = new ArrayList<>(); // 이 하이퍼튜브가 어떤 역과 연결되어 있는지 저장.

        for (int i = 0; i <= N; i++) {
            stations.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            hyperTube.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());
                stations.get(station).add(i);
                hyperTube.get(i).add(station);
            }
        }

        System.out.println(N == 1 ? 1 : bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[] visitedS = new boolean[N + 1];
        boolean[] visitedHT = new boolean[M];
        visitedS[1] = true;
        for (Integer ht : stations.get(1)) {
            visitedHT[ht] = true;
            q.add(new Node(ht, 1));
        }
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (Integer stationNum : hyperTube.get(c.hNum)) {
                if (stationNum == N) return c.count + 1;
                if (!visitedS[stationNum]) {
                    visitedS[stationNum] = true;
                    for (Integer hyperTubeNum : stations.get(stationNum)) {
                        if (!visitedHT[hyperTubeNum]) {
                            visitedHT[hyperTubeNum] = true;
                            q.add(new Node(hyperTubeNum, c.count + 1));
                        }
                    }
                }
            }
        }
        return -1;

    }

    private static class Node {
        int hNum, count;

        public Node(int n, int count) {
            this.hNum = n;
            this.count = count;
        }
    }
}
