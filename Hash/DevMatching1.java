import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DevMatching1 {
    public static void main(String[] args) {
        String[] registered_list = {"bird99", "bird98", "bird101", "gotoxy"};
        String new_id = "bird98";
        Set<String> set = new HashSet<>();

        Collections.addAll(set, registered_list);
        String S = "";
        String N = "";

        for (int i=0; i<new_id.length(); i++) {
            System.out.println("new_id = " + (int)new_id.charAt(i));
            if(new_id.charAt(i)>=49 && new_id.charAt(i)<=57) {
                S = new_id.substring(0,i);
                N = new_id.substring(i);
                break;
            }
        }
        if(N.length()==0){
            N = "0";
            S = new_id;
        }
        System.out.println("S = " + S);
        System.out.println("N = " + N);
        while (set.contains(new_id)) {
            int num = Integer.parseInt(N);
            num++;
            N = Integer.toString(num);
            new_id = S+N;
        }

        String answer = new_id;
        System.out.println("answer = " + answer);

    }
}
