import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek1697 {
    static int K;
    static int N;
    static int[] count = new int[100001];
    static int[] check = new int[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N==K){
            System.out.println(0);
        } else{
            solve();
            System.out.println(count[K]);
        }
    }
    static void solve(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        check[N]=3;
        while(!q.isEmpty()){
            int temp = q.poll();

            if(temp*2<=100000 && temp*2>=0 && check[temp*2]<3){
                check[temp*2]++;
                q.add(temp*2);
                if(count[temp*2]==0){
                    count[temp*2] = count[temp]+1;
                }
                else{
                    count[temp*2] = Math.min(count[temp]+1,count[temp*2]);
                }
            }
            if(temp+1<=100000 && temp+1>=0 && check[temp+1]<3){
                check[temp+1]++;
                q.add(temp+1);
                if(count[temp+1]==0){
                    count[temp+1] = count[temp]+1;
                }
                else{
                    count[temp+1] = Math.min(count[temp]+1,count[temp+1]);
                }
            }
            if(temp-1<=100000 && temp-1>=0 && check[temp-1]<3){
                check[temp-1]++;
                q.add(temp-1);
                if(count[temp-1]==0){
                    count[temp-1] = count[temp]+1;
                }
                else{
                    count[temp-1] = Math.min(count[temp]+1,count[temp-1]);
                }
            }
        }
    }
}
