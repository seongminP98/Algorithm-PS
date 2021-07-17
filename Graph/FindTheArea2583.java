import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FindTheArea2583 {
    static int M,N,K;
    static int[][] arr;
    static int[] rec;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        rec = new int[4];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                rec[j] = Integer.parseInt(st.nextToken());
            }
            for(int x=rec[1]; x<rec[3]; x++){
                for(int y=rec[0]; y<rec[2]; y++){
                    arr[x][y] = 1;
                }
            }
        }
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==0){
                    pq.add(bfs(i,j));
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append(' ');
        }
        System.out.println(count);
        System.out.println(sb);

    }

    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        int range = 1;
        q.add(new Node(x,y));
        arr[x][y] = 1;
        while(!q.isEmpty()){
            int cx = q.peek().x;
            int cy = q.peek().y;
            //int cr = q.peek().r;
            q.poll();
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(arr[nx][ny] == 0){
                        arr[nx][ny]=1;
                        range++;
                        q.add(new Node(nx,ny));
                    }
                }
            }
        }
        //System.out.println("range: "+range);
        return range;

    }
    static class Node{
        int x,y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}


