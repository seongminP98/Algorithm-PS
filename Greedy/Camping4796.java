import java.util.*;
public class Camping4796 {
    public static void main(String[] args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        List<Integer> ans = new ArrayList<Integer>();
        int L, P, V;

        while(true){
            L = sc.nextInt();
            P = sc.nextInt();
            V = sc.nextInt();
            if(L==0)
                break;
            int count=0;

            count += (V/P)*L;
            count += Math.min(V%P,L);

            ans.add(count);
        }
        int k=1;
        for(Integer i : ans) {
            System.out.println("Case " + k + ": " + i);
            k++;
        }
    }
}
