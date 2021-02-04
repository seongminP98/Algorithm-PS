import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LostBracket1541 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sub = new StringTokenizer(br.readLine(),"-");
        StringTokenizer first = new StringTokenizer(sub.nextToken(),"+");
        int result = 0;
        while(first.hasMoreTokens())
            result += Integer.parseInt(first.nextToken());//첫번째 값 항상 양수

        while(sub.hasMoreTokens()){
            int temp=0;
            StringTokenizer add = new StringTokenizer(sub.nextToken(),"+");
            while(add.hasMoreTokens()){
                temp += Integer.parseInt(add.nextToken());
            }
            result -= temp;
        }
        System.out.println(result);
    }
}
