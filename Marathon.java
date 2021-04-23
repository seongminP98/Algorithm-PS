import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Marathon {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] participant = new String[n];
        String[] completion = new String[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            participant[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            completion[i] = st.nextToken();
        }
        System.out.println(solution(participant,completion));
    }
    static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<participant.length; i++){
            if(hm.containsKey(participant[i]))
                hm.put(participant[i],hm.get(participant[i])+1);
            else
                hm.put(participant[i],1);
        }

        for(int i=0; i<completion.length; i++){
            hm.put(completion[i],hm.get(completion[i])-1);
        }

        String answer = "";
        for(String key : hm.keySet()){
            if(hm.get(key)==1)
                answer = key;
        }
        return answer;
    }

}



