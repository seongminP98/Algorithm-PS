import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Logo3108 {
    static int N;
    static boolean[] visited;
    static Rect[] arr;
    static int count=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Rect[N+1];
        arr[0] = new Rect(0,0,0,0); //시작위치
        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            arr[i] = new Rect(x1,y1,x2,y2);
        }
        visited = new boolean[N+1];

        bfs();
        System.out.println(count-1); //탐색이 끝나고 마지막에 들기때문.

    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<N+1; i++){
            if(!visited[i]){
                q.add(i);
                visited[i] = true;

                while(!q.isEmpty()){
                    int temp = q.poll();
                    for(int j=0; j<N+1; j++){
                        if(temp==j || !check(temp,j) || visited[j])
                            continue;

                        visited[j] = true;
                        q.add(j);
                    }
                }
                count++;
            }
        }
    }
    static boolean check(int current, int next){ //다음 사각형이 겹치면 PU안해도 됨.
        Rect c = arr[current];
        Rect n = arr[next];

        if((c.x1 < n.x1 && n.x2 < c.x2 && c.y1 < n.y1 && n.y2 < c.y2) //다음 사각형이 내부에 있을 때
                || (c.x1 > n.x1 && n.x2 > c.x2 && c.y1 > n.y1 && n.y2 > c.y2) //현재 사각형이 다음사각형 내부에 있을 때
                || c.x2 < n.x1 || n.x2 < c.x1 || c.y2 < n.y1 || n.y2 < c.y1){//서로 떨어져 있을 때
            return false;
        }
        return true;
    }
}
class Rect{
    int x1;
    int y1;
    int x2;
    int y2;
    Rect(int x1, int y1, int x2, int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
}