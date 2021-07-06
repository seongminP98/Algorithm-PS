import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire5427 {
    static int w,h;
    static char[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            visited = new boolean[h][w];
            for(int i=0; i<h; i++){
                String s = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] = s.charAt(j);
                }
            }

            bfs();
        }
        System.out.println(sb);
    }
    static void bfs(){
        Queue<Node5427> q = new LinkedList<>();
        Queue<Node5427> q2 = new LinkedList<>();

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == '@'){
                    q.add(new Node5427(i,j,0));
                    visited[i][j] = true;
                }
                else if(map[i][j] == '*'){
                    q2.add(new Node5427(i,j,0));
                }
            }
        }
        boolean check = true;
        boolean flag = true;
        while(flag){
            int c = q2.size();
            if(check && !q2.isEmpty()){
                for(int k=0; k<c; k++){
                    int x = q2.peek().x;
                    int y = q2.peek().y;
                    q2.poll();
                    for(int i=0; i<4; i++){
                        int nx = x+dx[i];
                        int ny = y+dy[i];
                        if(nx>=0 && nx<h && ny>=0 && ny<w){
                            if(map[nx][ny] == '.'){
                                q2.add(new Node5427(nx,ny,0));
                                map[nx][ny] = '*';
                            }
                        }
                    }
                }
                check = false;
            }
            else{
                int c2 = q.size();
                if(q.isEmpty()){
                    sb.append("IMPOSSIBLE").append('\n');
                    flag = false;
                    break;
                }
                loop : for(int k=0; k<c2; k++){

                    int x = q.peek().x;
                    int y = q.peek().y;
                    int count = q.peek().count;
                    q.poll();
                    for(int i=0; i<4; i++){
                        int nx = x+dx[i];
                        int ny = y+dy[i];
                        if(nx>=0 && nx<h && ny>=0 && ny<w){
                            if(!visited[nx][ny] && map[nx][ny] == '.'){
                                q.add(new Node5427(nx,ny,count+1));
                                visited[nx][ny] = true;
                                map[x][y] = '.';
                                //map[nx][ny] = '@';
                            }
                        }else{
                            sb.append(count+1).append('\n');
                            flag = false;
                            break loop;
                        }
                    }
                }
                check = true;
            }

        }
    }
}
class Node5427{
    int x,y,count;
    Node5427(int x, int y, int count){
        this.x=x;
        this.y=y;
        this.count=count;
    }
}