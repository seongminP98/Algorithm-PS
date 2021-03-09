import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WordFlip17413 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s += ' ';
        String result = "";

        for(int i=0; i<s.length(); i++){
            String temp = "";
            if(s.charAt(i)=='<'){
                while(s.charAt(i)!='>'){
                    result += s.charAt(i);
                    i++;
                }
                result += s.charAt(i); // '>'
            } else{
                while(s.charAt(i) != ' ') {
                    if(s.charAt(i) == '<'){
                        i--;
                        break;
                    }
                    temp += s.charAt(i);
                    i++;
                }
                result += new StringBuffer(temp).reverse().toString();
                if(s.charAt(i)==' ')
                    result += s.charAt(i);
            }
        }
        System.out.println(result);
    }
}
