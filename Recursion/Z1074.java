import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z1074 {
    static int N,c,r;

    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solution(0,0,N,0);

    }
    static void solution(int x, int y, int n, int num){
        if(n==1){
            for(int i=x; i<x+2; i++){
                for(int j=y; j<y+2; j++){
                    if(i==r && j==c){
                        System.out.print(num);
                        System.exit(0);
                    }
                    num++;

                }
            }
        } else{
            if(r>=x+(int)Math.pow(2,n)/2){
                if(c>=y+(int)Math.pow(2,n)/2){ //오른쪽아래
                    solution(x+(int)Math.pow(2,n)/2,y+(int)Math.pow(2,n)/2,n-1,(int)Math.pow((int)Math.pow(2,n-1),2)*3+num);
                }
                else{ //왼쪽 아래
                    solution(x+(int)Math.pow(2,n)/2,y,n-1,(int)Math.pow((int)Math.pow(2,n-1),2)*2+num);
                }
            } else{
                if(c>=y+(int)Math.pow(2,n)/2){ //오른쪽 위
                    solution(x,y+(int)Math.pow(2,n)/2,n-1,(int)Math.pow((int)Math.pow(2,n-1),2)+num);
                }
                else{ //왼쪽 위
                    solution(x,y,n-1,num);
                }
            }
        }
    }
}
/* 다른사람의 풀이
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,c,r;
    static int ans = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solution(0,0,(int)Math.pow(2,N));
    }
    static void solution(int x, int y, int n){
        if(x==r && y==c){
            System.out.print(ans);
            System.exit(0);
        }
        if(x<=r && r<(x+n) && y<=c && c<(y+n)){
            solution(x,y,n/2);
            solution(x,y+n/2,n/2);
            solution(x+n/2,y,n/2);
            solution(x+n/2,y+n/2,n/2);
        } else{
            ans += n*n;
        }
    }
}
 */