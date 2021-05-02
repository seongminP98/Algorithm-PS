import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR9019 {
    static int A;
    static int B;
    static boolean[] check;
    static String[] ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            check = new boolean[10000];
            ans = new String[10000];
            for(int j=0; j<10000; j++){
                ans[j] = "";
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs();
            sb.append(ans[B]).append('\n');
        }
        System.out.println(sb);
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        check[A]=true;
        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp==B)
                return; //이걸 해주는게 시간이 더 적게 걸림.
            if(!check[D(temp)]){
                check[D(temp)] = true;
                q.add(D(temp));
                ans[D(temp)] += ans[temp]+"D";
            }
            if(!check[S(temp)]){
                check[S(temp)] = true;
                q.add(S(temp));
                ans[S(temp)] += ans[temp]+"S";
            }
            if(!check[L(temp)]){
                check[L(temp)] = true;
                q.add(L(temp));
                ans[L(temp)] += ans[temp]+"L";
            }
            if(!check[R(temp)]){
                check[R(temp)] = true;
                q.add(R(temp));
                ans[R(temp)] += ans[temp]+"R";
            }

        }
    }
    static int D(int n){
        n*=2;
        if(n>9999)
            return n%10000;
        else
            return n;
    }
    static int S(int n){
        n-=1;
        if(n<0)
            return 9999;
        else
            return n;
    }
    static int L(int n){
        int m = n/1000;
        n-=m*1000;
        n*=10;
        n+=m;
        return n;
    }
    static int R(int n){
        int m = n%10;
        n/=10;
        m*=1000;
        n+=m;
        return n;
    }
}
