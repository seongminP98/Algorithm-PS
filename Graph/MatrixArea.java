import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MatrixArea {
    static boolean[][] visited;
    static List<Integer> sizeOfArea;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfMatrix = Integer.parseInt(br.readLine());
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int i=0; i<matrix.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<matrix.length; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[sizeOfMatrix][sizeOfMatrix];
        int ans = 0;

        sizeOfArea = new ArrayList<>();
        for( int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    sizeOfArea.add(bfs(i,j,sizeOfMatrix, matrix));
                    ans++;
                }
            }
        }
        System.out.println("ans = " + ans);
        Collections.sort(sizeOfArea);
        for (Integer i : sizeOfArea) {
            System.out.print(i+ " ");
        }

    }
    static int bfs(int x, int y, int size, int[][] matrix) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        int sizeOfArea = 1;
        while(!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            for (int i=0; i<4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && nx<size && ny>=0 && ny<size && matrix[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new Node(nx, ny));
                    sizeOfArea++;
                    visited[nx][ny] = true;
                }
            }
        }
        return sizeOfArea;
    }
    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
