import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BabyShark16236 {
    static int N;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int answer, size, eat;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        eat = 0;
        size = 2;
        loop: for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 9 ){
                    arr[i][j] = 0;
                    bfs(i,j);
                    break loop;
                }
            }
        }
        System.out.println(answer);

    }
    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,2));
        while(true) {
            List<Node> fish = new ArrayList<>();
            int[][] distance = new int[N][N];
            while(!q.isEmpty()) {
                int cx = q.peek().x;
                int cy = q.peek().y;
                q.poll();
                for(int i=0; i<4; i++) {
                    int nx = cx+dx[i];
                    int ny = cy+dy[i];
                    if(nx>=0 && nx<N && ny>=0 && ny<N && arr[nx][ny]<=size && distance[nx][ny]==0) {
                        distance[nx][ny] = distance[cx][cy] + 1;
                        q.add(new Node(nx,ny,distance[nx][ny])); //갈수 있는 공간의 위치와, 거리
                        if(arr[nx][ny] > 0 && arr[nx][ny] < size) { //먹을 수 있으면 리스트에 넣음
                            fish.add(new Node(nx,ny,distance[nx][ny]));
                        }
                    }
                }
            }
            if(fish.size() == 0) {
                return;
            }
            Node cFish = fish.get(0);
            for(int i=1; i<fish.size(); i++) { //먹을 수 있는 물고기중 가까운 > 위 > 왼쪽 순으로
                if(cFish.distance > fish.get(i).distance) {
                    cFish = fish.get(i);
                } else if(cFish.distance == fish.get(i).distance) {
                    if(cFish.x > fish.get(i).x) {
                        cFish = fish.get(i);
                    } else if(cFish.x == fish.get(i).x) {
                        if(cFish.y > fish.get(i).y) {
                            cFish = fish.get(i);
                        }
                    }
                }
            }

            answer += cFish.distance;
            eat++;
            arr[cFish.x][cFish.y] = 0;
            if(eat == size) {
                size++;
                eat = 0;
            }
            q.add(new Node(cFish.x, cFish.y, 0));
        }
    }

    static class Node{
        int x,y,distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}

