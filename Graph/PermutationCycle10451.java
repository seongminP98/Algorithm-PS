import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PermutationCycle10451 {
    static boolean[] visit;
    static List<Integer>[] al;
    static int count=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            visit = new boolean[n+1];
            al = new ArrayList[n+1];
            for(int j=0; j<n+1; j++){
                al[j] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++){
                int a = Integer.parseInt(st.nextToken());
                al[j].add(a);
            }

            for(int j=1; j<n+1; j++){
                bfs(j);
            }
            System.out.println(count);
            count =0;

        }
    }
    static void bfs(int i){
        if(visit[i])
            return;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i]=true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int value : al[temp]){
                if(!visit[value]){
                    visit[value]=true;
                    q.offer(value);
                }
            }
        }
        count++;
    }
}
