import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen9663 {
    static int N;
    static int count = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; //index는 column, 값은 row
        solve(0);
        System.out.println(count);
    }
    static void solve(int depth){
        if(depth == N){
            count++;
            return;
        }
        for(int i=0; i<N; i++){
            arr[depth] = i;
            if(possible(depth)){
                solve(depth+1);
            }
        }

    }
    static boolean possible(int c){ //이 자리에 놓을 수 있는지 확인
        for(int i=0; i<c; i++){
            if(arr[c] == arr[i]){ //같은 행에 있는지 확인
                return false;
            }
            else if(Math.abs(c-i) == Math.abs(arr[c]-arr[i])) //대각선에 있는지 확인(열의 차와 행의 차가 같으면 대각선)
                return false;
        }
        return true;

    }
}
