import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DifferNumOfSub11478 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Set<String> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length()+1; j++){
                set.add(s.substring(i,j));
            }
        }

        System.out.println(set.size()-1);//공백문자열 하나뺌
    }
}
