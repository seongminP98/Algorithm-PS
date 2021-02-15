import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge1010 {
    static int[][] bridge = new int[30][30];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(combination(m,n));
        }

    }
    static int combination(int n, int r){ //조합 
        if(bridge[n][r]>0){
            return bridge[n][r];
        }

        if(n==r || r==0){
            return bridge[n][r]=1;
        }

        return bridge[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
}
