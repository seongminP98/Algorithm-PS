import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class KeyLogger5397 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String s = br.readLine();
            List<Character> list = new LinkedList();
            int cursor = 0;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)=='<'){
                    if(cursor>0){
                        cursor--;
                    }
                } else if(s.charAt(j)=='>'){
                    if(cursor<list.size())
                        cursor++;
                } else if(s.charAt(j)=='-'){
                    if(list.size()>0 && cursor>0){
                        cursor--;
                        list.remove(cursor);
                    }
                } else{
                    list.add(cursor,s.charAt(j));
                    cursor++;
                }
            }
            for(Character c : list){
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
