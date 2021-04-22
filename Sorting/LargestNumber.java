import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args){
        int[] num = new int[]{3, 30, 34, 5, 9};
        String answer = "";
        String[] ans = new String[num.length];
        for(int i=0; i<num.length; i++){
            ans[i] = Integer.toString(num[i]);
        }
        Arrays.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(ans[0].equals("0")){
            answer = "0";
        }else{
            StringBuilder sb = new StringBuilder();

            for (String s : ans) {
                sb.append(s);
            }
            answer = sb.toString();
        }
        System.out.println(answer);

    }
}
