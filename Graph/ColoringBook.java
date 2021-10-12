import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    static int m = 6;
    static int n = 4;
    static int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    static boolean[][] visited = new boolean[m][n];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int maxSizeOfOneArea = 0;
    static int numberOfArea = 0;
    public static void main(String[] args) {


        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (picture[i][j]!=0 && !visited[i][j]) {
                    bfs(i,j,picture[i][j],m,n,picture);
                }
            }
        }

        System.out.println("numberOfArea = " + numberOfArea);
        System.out.println("maxSizeOfOneArea = " + maxSizeOfOneArea);

    }
    static void bfs(int x, int y, int value, int m, int n, int[][] picture) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        int area = 0;
        numberOfArea++;
        while (!q.isEmpty()) {
            int cx = q.peek().x;
            int cy = q.peek().y;
            q.poll();
            area++;
            for(int i=0; i<4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n) {
                    if(!visited[nx][ny] && picture[nx][ny]==value) {
                        q.add(new Node(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
/**
 * static 사용해서 전역변수로 dx, dy, visited 만들어서 하니까 테스트 케이스는 통과하지만
 * 제출했을 때 실패 함.
 * 왜?? => 이유를 모르겠음
 * 찾아보니 전역 변수를 정의할 경우 함수 내에 초기화 코드를 작성해 달라고 주석이 있었다고 한다.
 * 나는 함수 밖에서 초기화 함.
 * 그래서 전역변수 사용하지 않고, bfs 메소드를 따로 생성하지 않고 solution 메소드에서 다 해결하니까 통과함.
 */
/*
import java.util.LinkedList;
import java.util.Queue;
class Solution {

    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int maxSizeOfOneArea = 0;
        int numberOfArea = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (picture[i][j]!=0 && !visited[i][j]) {
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i,j));
                    visited[i][j] = true;
                    int area = 0;
                    numberOfArea++;
                    while (!q.isEmpty()) {
                        int cx = q.peek().x;
                        int cy = q.peek().y;
                        q.poll();
                        area++;
                        for(int k=0; k<4; k++) {
                            int nx = cx+dx[k];
                            int ny = cy+dy[k];
                            if(nx>=0 && nx<m && ny>=0 && ny<n) {
                                if(!visited[nx][ny] && picture[nx][ny]==picture[i][j]) {
                                    q.add(new Node(nx,ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
 */