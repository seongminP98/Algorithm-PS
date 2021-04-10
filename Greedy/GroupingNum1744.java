import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupingNum1744 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num<=0)
                neg.add(num);
            else
                pos.add(num);
        }
        Collections.sort(neg);
        Collections.sort(pos);
        long result=0;

        for(int i=0; i<neg.size(); i++){
            if(i==neg.size()-1)
                result+=neg.get(i);
            else{
                result+=(neg.get(i)*neg.get(i+1));
                i++;
            }
        }

        for(int i=pos.size()-1; i>=0; i--){
            if(i==0)
                result+=pos.get(i);
            else{
                if(pos.get(i)!=1 && pos.get(i-1)!=1){
                    result+=(pos.get(i)*pos.get(i-1));
                    i--;
                }else{
                    result+=pos.get(i);
                }
            }
        }
        System.out.println(result);
    }
}
