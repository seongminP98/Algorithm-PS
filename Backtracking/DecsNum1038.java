import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class DecsNum1038 {
    static int n;
    static ArrayList<Long> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n>1022){ //9876543210
            System.out.println(-1);
            System.exit(0);
        }
        list = new ArrayList<>();
        for(int i=0; i<10; i++){
            decs(i,1);
        }
        Collections.sort(list);
        System.out.println(list.get(n));

    }
    static void decs(long num, int temp){ //작아지는 수들 list에 넣기. 
        if(temp>10){
            return;
        }
        list.add(num);
        for(int i=0; i<10; i++){
            if(num%10>i){
                decs((num*10)+i,temp+1);
            }
        }
    }

}
