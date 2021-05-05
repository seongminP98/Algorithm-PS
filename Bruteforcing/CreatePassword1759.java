import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CreatePassword1759 {
    static int L,C;
    static char[] arr;
    static int[] result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        result = new int[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        solve(0,"");
    }
    static void solve(int index, String s){
        if(s.length()==L){
            if(vowConsNum(s)){
                System.out.println(s);
            }
            return;
        }
        if(index>=C){
            return;
        }
        solve(index+1,s+arr[index]);//현재 index의 문자 포함.
        solve(index+1,s);//현재 index의 문자 포함x

    }
    static boolean check(char c){ //모음 확인
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    static boolean vowConsNum(String s){ //모음 개수1개이상 자음 개수2개 이상이면 true
        int vowel=0;
        int consonant = 0;
        for(int i=0; i<s.length(); i++){
            if(check(s.charAt(i)))
                vowel++;
            else
                consonant++;
        }
        return vowel >= 1 && consonant >= 2;
    }
}
