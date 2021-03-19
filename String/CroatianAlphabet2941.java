import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CroatianAlphabet2941 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int result = 0;
        for(int i=0; i<s.length(); i++){
            if(i>=s.length()-1){
                result++;
                break;
            }
            if(s.charAt(i)=='c'){
                if(s.charAt(i+1)=='=' || s.charAt(i+1)=='-'){
                    i++;
                }
            } else if(s.charAt(i)=='d'){
                if(s.charAt(i+1)=='z'){
                    if(i+1>=s.length()-1){
                        result+=2;
                        break;
                    }
                    if(s.charAt(i+2)=='=')
                        i+=2;
                } else if(s.charAt(i+1)=='-')
                    i++;
            } else if(s.charAt(i)=='l'){
                if(s.charAt(i+1)=='j')
                    i++;
            } else if(s.charAt(i)=='n') {
                if (s.charAt(i + 1) == 'j')
                    i++;
            } else if(s.charAt(i)=='s'){
                if(s.charAt(i+1)=='=')
                    i++;
            } else if(s.charAt(i)=='z'){
                if(s.charAt(i+1)=='=')
                    i++;
            }
            result++;
        }
        System.out.println(result);
    }
}
