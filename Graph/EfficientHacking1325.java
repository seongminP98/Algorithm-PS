import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EfficientHacking1325 {
    static int N,M;
    static ArrayList<Integer>[] al;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        al = new ArrayList[N+1];
        arr = new int[N+1];
        for(int i=1; i<=N; i++)
            al[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(b);
        }

        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            visit = new boolean[N+1];
            bfs(i);
        }
        for(int i=1; i<=N; i++) {
            max = Math.max(max, arr[i]);
        }
        for(int i=1; i<=N; i++){
            if(arr[i] == max)
                sb.append(i).append(' ');
        }
        System.out.print(sb);

    }
    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visit[s] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=0; i<al[temp].size(); i++){
                int v = al[temp].get(i);
                if(!visit[v]){
                    visit[v] = true;
                    arr[v]++;
                    q.add(v);
                }
            }
        }
    }
}
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EfficientHacking1325 {
    static int N,M;
    static int[][] arr;
    static int count = 0;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //int[] ans = new int[N+1];
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            count = 0;
            bfs(i);
            //ans[i] = count;
            if(count>max){
                max = count;
                sb.setLength(0);
                sb.append(i).append(' ');
            } else if(count==max){
                sb.append(i).append(' ');
            }
        }

//        for(int i=1; i<=N; i++){
//            if(max==ans[i]){
//                sb.append(i).append(' ');
//            }
//        }

        System.out.print(sb);

    }
    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        count++;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=0; i<M; i++){
                if(temp == arr[i][1]){
                    q.add(arr[i][0]);
                    count++;

                }
            }
        }
    }
}
 */