import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlainSquare {
    static long W,H;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        W = Long.parseLong(br.readLine());
        H = Long.parseLong(br.readLine());
        long result = 0;
        for(int i=0; i<W; i++){
            result += H*i/W; //일차함수 사용. 소수점은 날리기위해 곱하기 먼저.
        }
        System.out.println(result*2); //대칭이기때문에 x2

    }
}
