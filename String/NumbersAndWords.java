import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumbersAndWords {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i=0; i<words.length; i++) {
            str = str.replace(words[i], numbers[i]);
        }
        int answer = Integer.parseInt(str);

        System.out.println("str = " + str);

    }
}
/*
class Solution {
    public int solution(String s) {
        String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i=0; i<words.length; i++) {
            s = s.replace(words[i], numbers[i]);
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}
 */