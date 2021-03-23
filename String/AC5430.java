import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class AC5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            String f = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Deque<String> arr = new LinkedList<>();
            boolean r = false;
            boolean error = false;
            for(String str : s.substring(1,s.length()-1).split(",")){
                if(!str.equals(""))
                    arr.add(str);
            }
            for(int j=0; j<f.length(); j++){
                if(f.charAt(j)=='R'){
                    r = !r;
                }
                else{
                    if(arr.size()==0){
                        error = true;
                        break;
                    }
                    if(!r)
                        arr.remove();
                    else
                        arr.removeLast();
                }
            }
            if(!error){
                sb.append("[");
                if(r){
                    while(!arr.isEmpty()){
                        sb.append(arr.removeLast());
                        if(arr.size()!=0)
                            sb.append(",");
                    }
                } else{
                    while(!arr.isEmpty()){
                        sb.append(arr.remove());
                        if(arr.size()!=0)
                            sb.append(",");
                    }
                }
                sb.append("]");
            } else{
                sb.append("error");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
