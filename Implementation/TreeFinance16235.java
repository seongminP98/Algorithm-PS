import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class TreeFinance16235 {
    static int N, M, K;
    static int[][] A; //각 칸에 추가되는 양분
    static int[][] arr; //양분
    static Queue<Tree> list = new LinkedList<>();
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {-1, 0, 1, 1, -1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //땅 크기
        M = Integer.parseInt(st.nextToken()); //나무 개수
        K = Integer.parseInt(st.nextToken()); //K년이 지난 후
        A = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort((List<Tree>) list); //정렬을 시작할 때 한번만 해야지 시간초과 안남.
        while (K-- > 0) {
            springSummer();
            autumn();
            winter();
        }
        bw.write(String.valueOf(list.size()));
        bw.flush();
        bw.close();
    }

    static void springSummer() {
        List<Tree> deadTree = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Tree current = list.poll();
            int x = current.x;
            int y = current.y;
            int z = current.z;
            if (arr[x][y] >= z) {
                arr[x][y] -= z;
                list.add(new Tree(x, y, z + 1));
            } else {
                deadTree.add(new Tree(x, y, z / 2));
            }
        }
        for (Tree tree : deadTree) {
            arr[tree.x][tree.y] += tree.z;
        }
    }

    static void autumn() {
        int size = list.size();
        List<Tree> parent = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Tree current = list.poll();
            if (current.z % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];
                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                        list.add(new Tree(nx, ny, 1));
                    }
                }
            }
            parent.add(current);
        }
        list.addAll(parent); //정렬상태를 유지하기 위해 번식을 하는 부모트리는 마지막에 한꺼번에 추가해줌.
    }

    static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] += A[i][j];
            }
        }
    }

    static class Tree implements Comparable<Tree> {
        int x, y, z;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;//나이
        }

        @Override
        public int compareTo(Tree o) {
            return z - o.z;
        }

    }
}
