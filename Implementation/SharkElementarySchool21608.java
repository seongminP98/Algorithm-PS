import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SharkElementarySchool21608 {
    static int N;
    static List<HashSet<Integer>> list;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] order;
    static Set<Integer> sit = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        order = new int[N * N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N * N; i++) {
            list.add(new HashSet<>());
        }
        StringTokenizer st;
        for (int i = 1; i <= N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;
            for (int j = 0; j < 4; j++) {
                list.get(num).add(Integer.parseInt(st.nextToken()));
            }
        }


        arr[1][1] = order[1];
        sit.add(order[1]);
        for (int i = 2; i <= N * N; i++) {
            int num = order[i];
            PriorityQueue<Node> checkSit = new PriorityQueue<>();
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (arr[x][y] == 0) {
                        int likeCnt = 0;
                        int emptyCnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (arr[nx][ny] == 0) {
                                    emptyCnt++;
                                } else if (list.get(num).contains(arr[nx][ny])) {
                                    likeCnt++;
                                }
                            }
                        }
                        checkSit.add(new Node(x, y, likeCnt, emptyCnt));
                    }
                }
            }
            arr[checkSit.peek().x][checkSit.poll().y] = num;
        }

        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (list.get(arr[i][j]).contains(arr[nx][ny])) {
                            cnt++;
                        }
                    }
                }
                switch (cnt) {
                    case 1:
                        answer += 1;
                        break;
                    case 2:
                        answer += 10;
                        break;
                    case 3:
                        answer += 100;
                        break;
                    case 4:
                        answer += 1000;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(answer);

    }

    static class Node implements Comparable<Node> {
        int x, y, like, empty;

        public Node(int x, int y, int like, int empty) {
            this.x = x;
            this.y = y;
            this.like = like;
            this.empty = empty;
        }

        @Override
        public int compareTo(Node o) {
            if (like == o.like) {
                if (empty == o.empty) {
                    if (x == o.x) {
                        return y - o.y;
                    }
                    return x - o.x;
                }
                return o.empty - empty;
            }
            return o.like - like;
        }
    }
}
