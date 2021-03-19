import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Ship1092 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        int result = 0;
        if(crane.get(0)<box.get(0)){
            System.out.println(-1);
        } else{
            while(box.size()!=0){
                int index = 0;
                int tmp = 0;
                while(index<N){
                    if(tmp>=box.size())
                        break;
                    if(crane.get(index)>=box.get(tmp)){
                        box.remove(tmp);
                        index++;
                    } else{
                        tmp++;
                    }

                }
                result++;
            }
            System.out.println(result);
        }
    }
}
