import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Escape3055 {
    static int R,C;
    static char[][] map;
    static char[][] arr;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        arr = new char[R][C];
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
            }
        }
        bfs();
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(map[i][j]+" ");
//            }System.out.println();
//        }
        System.out.println("KAKTUS");

    }
    static void bfs(){
        Queue<Node3055> water = new LinkedList<>();
        Queue<NodeBeaver> beaver = new LinkedList<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]=='S'){
                    beaver.add(new NodeBeaver(i,j,ans));
                }
                if(map[i][j]=='*'){
                    water.add(new Node3055(i,j));
                }
            }
        }
        boolean check = true;
        while(true){
            if(beaver.size()==0){
                System.out.println("KAKTUS");
                System.exit(0);
            }
            if(check){
                int l = water.size();
                for(int q=0; q<l; q++){
                    int x = water.peek().x;
                    int y = water.peek().y;
                    water.poll();
                    for(int i=0; i<4; i++){
                        int nx = x+dx[i];
                        int ny = y+dy[i];
                        if(nx>=0 && ny>=0 && nx<R && ny<C){
                            if(map[nx][ny] == '.' || map[nx][ny] == 'S'){
                                map[nx][ny] = '*';
                                water.add(new Node3055(nx,ny));
                            }
                        }
                    }
//                    for(int k=0; k<R; k++){
//                        for(int j=0; j<C; j++){
//                            System.out.print(map[k][j]+" ");
//                        }System.out.println();
//                    }

                }

                check = false;
            }else{
                int l = beaver.size();
                for(int q=0; q<l; q++){
                    int x = beaver.peek().x;
                    int y = beaver.peek().y;
                    int time = beaver.peek().t;
                    beaver.poll();
                    for(int i=0; i<4; i++){
                        int nx = x+dx[i];
                        int ny = y+dy[i];
                        if(nx>=0 && ny>=0 && nx<R && ny<C){
                            if(map[nx][ny] == '.'){
                                map[nx][ny] = 'S';
                                beaver.add(new NodeBeaver(nx,ny,time+1));
                            }else if(map[nx][ny]=='D'){

                                System.out.println(time+1);
                                System.exit(0);
                            }
                        }
                    }
//                    for(int k=0; k<R; k++){
//                        for(int j=0; j<C; j++){
//                            System.out.print(map[k][j]+" ");
//                        }System.out.println();
//                    }
//                    System.out.println("=============");
                }

                check = true;
            }
        }

    }
}
class Node3055{
    int x,y;
    Node3055(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class NodeBeaver{
    int x,y,t;
    NodeBeaver(int x, int y,int t){
        this.x=x;
        this.y=y;
        this.t=t;
    }
}