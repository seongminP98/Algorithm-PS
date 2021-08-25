import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EnergyGathering16198 {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        dfs(list,0);
        System.out.println(max);

    }
    static void dfs(List<Integer> list, int sum) {
        if(list.size()<=2) {
            max = Math.max(sum,max);
            return;
        }

        for(int i=1; i<list.size()-1; i++) {
            int temp = list.get(i-1) * list.get(i+1);
            int value = list.get(i);
            list.remove(i);
            dfs(list,sum+temp);
            list.add(i,value);
        }
    }
}
