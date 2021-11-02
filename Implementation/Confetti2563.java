import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Confetti2563 {
    public static void main(String[] args) throws Exception{
        boolean[][] arr = new boolean[100][100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int r=x; r<x+10; r++) {
                for(int c=y; c<y+10; c++) {
                    arr[r][c]=true;
                }
            }
        }
        int answer = 0;
        for (boolean[] booleans : arr) {
            for (boolean aBoolean : booleans) {
                if(aBoolean) answer++;
            }
        }
        System.out.println(answer);
    }
}
