import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Change14916 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));

    }
    static int solution(int n){
        if(n==1 || n==3)
            return -1;

        else if(n%5==1 || n%5==4)
            return (n/5)-1+3;

        else if(n%5==2)
            return (n/5)+1;

        else if(n%5==3)
            return (n/5)-1+4;

        else
            return n/5;
    }
}
