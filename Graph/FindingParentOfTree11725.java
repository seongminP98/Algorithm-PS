import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FindingParentOfTree11725 {
    static int N;
    static int[] p;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        for(int i=2; i<=N; i++){
            System.out.println(p[i]);
        }

    }
    static void dfs(int node){
        for(int i : tree[node]){
            if(p[i]==0){
                p[i] = node;
                dfs(i);
            }
        }
    }
}
