import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AandB12904 {
    static String S, T;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        while(S.length()<T.length()){
            if(T.charAt(T.length()-1)=='A'){
                T = T.substring(0,T.length()-1);
            }
            else if(T.charAt(T.length()-1)=='B'){
                T = T.substring(0,T.length()-1);
                reverse();
            }
        }

        if(S.equals(T)){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }
    static void reverse(){
        StringBuffer sb = new StringBuffer(T);
        T = sb.reverse().toString();
    }
}
