import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BiGraph1707 {
    static ArrayList<Integer>[] al;
    static int visit[];
    static boolean checkBiGraph;
    public static void main(String[] args) throws Exception{
        int v,e;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            al = new ArrayList[v+1];
            for(int j=0; j<=v; j++){
                al[j] = new ArrayList<>();
            }
            visit = new int[v+1];
            checkBiGraph = true;
            for(int j=0; j<e; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                al[a].add(b);
                al[b].add(a);
            }
            for(int j=1; j<v+1; j++){
                if(!checkBiGraph)
                    break;

                if(visit[j]==0)
                    bfs(j,1);
            }
            if(checkBiGraph)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static void bfs(int i,int vi){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visit[i] = vi;
        while(!q.isEmpty() && checkBiGraph){
            int temp = q.poll();
            for(int vt : al[temp]){
                if(visit[vt]==0){
                    q.add(vt);
                    visit[vt]=visit[temp]*-1; //인접한 vertex는 1과 -1로 나눔.
                }
                else if(visit[temp]+visit[vt]!=0){ //인접한 vertex가 같으면 이분그래프 아님.
                    checkBiGraph = false;
                    return;
                }
            }
        }
    }
}
