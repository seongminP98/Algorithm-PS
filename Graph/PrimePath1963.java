import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrimePath1963 {
    static int A;
    static int B;
    static int[] count;
    static boolean[] isPrime = new boolean[10000];
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        prime();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            check = new boolean[10000];
            count = new int[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs();
            if(A==B){
                sb.append(0).append('\n');
            }else
                sb.append(count[B]).append('\n');
        }
        System.out.println(sb);

    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        while(!q.isEmpty()){
            int temp = q.poll();
            int n = temp;
            check[n] = true;
            for(int i=1; i<=1000; i*=10){
                int m = n%10; //자릿수
                n/=10;
                if(m==0){//원래 0이었으면 증가시키기만 하면됨.
                    for(int j=i; j<i*9; j+=i){
                        if(!isPrime[temp+j] && !check[temp+j]){
                            q.add(temp+j);
                            check[temp+j] = true;
                            if(count[temp+j]==0)
                                count[temp+j]=count[temp]+1;
                            else{
                                count[temp+j] = Math.min(count[temp+j],count[temp]+1);
                            }
                        }
                    }
                } else{
                    if(n==0){//천의자리
                        if(m!=1){ //천의 자리가 1이면 빼면 안됨.
                            for(int j=i; j<i*m; j+=i){
                                if(!isPrime[temp-j] && !check[temp-j]){
                                    q.add(temp-j);
                                    check[temp-j] = true;
                                    if(count[temp-j]==0)
                                        count[temp-j]=count[temp]+1;
                                    else{
                                        count[temp-j] = Math.min(count[temp-j],count[temp]+1);
                                    }
                                }
                            }
                        }
                    }
                    else{ //천의 자리가 아닐 때
                        for(int j=i; j<=i*m; j+=i){ //0이 될때까지 빼기
                            if(!isPrime[temp-j] && !check[temp-j]){
                                q.add(temp-j);
                                check[temp-j] = true;
                                if(count[temp-j]==0)
                                    count[temp-j]=count[temp]+1;
                                else{
                                    count[temp-j] = Math.min(count[temp-j],count[temp]+1);
                                }
                            }
                        }
                    }
                    for(int j=i; j<=i*(9-m); j+=i){ //9가 될때까지 더하기
                        if(!isPrime[temp+j] && !check[temp+j]){
                            q.add(temp+j);
                            check[temp+j] = true;
                            if(count[temp+j]==0)
                                count[temp+j]=count[temp]+1;
                            else{
                                count[temp+j] = Math.min(count[temp+j],count[temp]+1);
                            }
                        }
                    }
                }
            }
        }
    }
    static void prime(){
        isPrime[0] = true;
        isPrime[1] = true; //true면 소수아님
        for(int i=2; (i*i)<10000; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<10000; j+=i)
                    isPrime[j] = true;
            }
        }
    }
}
