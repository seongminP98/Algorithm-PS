import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KevinBaconSixStepRule1389 {
    static int N,M;
    static int[][] arr;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A][B] = 1;
            arr[B][A] = 1;
        }
        answer = new int[N+1];
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                visited = new boolean[N+1];
                answer[i] += bfs(i,j);
            }
            min = Math.min(answer[i], min);
        }
        for (int i=1; i<=N; i++) {
            if(answer[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }
    static int bfs(int n, int friend) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 1));
        visited[n] = true;
        while(!q.isEmpty()) {
            int c = q.peek().n;
            int count = q.poll().count;
            for(int i=1; i<=N; i++) {
                if(arr[c][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(new Node(i, count+1));
                    if(i == friend) {
                        return count;
                    }
                }
            }
        }
        return 0;
    }
    static class Node{
        int n, count;

        public Node(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
