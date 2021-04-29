import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HanoiTowerOrder11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2,N)-1).append("\n");
        hanoi(N,1,2,3);
        System.out.println(sb);
    }
    static void hanoi(int n, int A, int B, int C){
        if(n==1){ //이동할 수가 1개면
            sb.append(A+" "+C+"\n");
            return;
        }
        // n-1개를 A에서 B로 이동
        hanoi(n-1,A,C,B);

        //1개를 A에서 C로 이동
        sb.append(A+" "+C+"\n");

        //n-1개를 B에서 C로 이동
        hanoi(n-1,B,A,C);
    }
}
