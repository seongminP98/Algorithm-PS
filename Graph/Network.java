import java.util.LinkedList;
import java.util.Queue;

public class Network {
    static int n;
    static int[][] computers;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) {
        answer = 0;
        n = 3;
        computers = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        visited = new boolean[3];
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        System.out.println("answer = " + answer);
    }
    static void bfs(int c) {
        Queue<Integer> q = new LinkedList<>();
        q.add(c);
        while(!q.isEmpty()) {
            int cValue = q.poll();
            visited[cValue] = true;
            for (int i=0; i<n; i++) {
                if(computers[cValue][i] == 1 && !visited[i]) {
                    q.add(i);
                }
            }
        }
    }
}
