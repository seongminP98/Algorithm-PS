import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WordSorting1181 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word[] = new String[N];
        for(int i=0; i<N; i++){
            word[i] = br.readLine();
        }

        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                } else{
                    return o1.length() - o2.length();
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(word[0]).append('\n');
        for(int i = 1; i<N; i++){
            if(!word[i].equals(word[i-1])){
                sb.append(word[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
