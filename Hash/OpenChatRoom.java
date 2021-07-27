import java.util.HashMap;
import java.util.Map;

public class OpenChatRoom {
    public static void main(String[] args) {
        String[] record = new String[]{ "Enter uid1234 Muzi",
                                        "Enter uid4567 Prodo",
                                        "Leave uid1234",
                                        "Enter uid1234 Prodo",
                                        "Change uid4567 Ryan",
        "Enter uid33 park", "Enter uid22 kim"};

        Map<String,String> users = new HashMap<>();
        int len = 0;
        for (String s : record) {
            if(!s.split(" ")[0].equals("Leave")){
                String id = s.split(" ")[1];
                String nick = s.split(" ")[2];
                users.put(id,nick);
            }
            if(!s.split(" ")[0].equals("Change"))
                len++;
        }
        //StringBuilder sb = new StringBuilder();
        String[] answer = new String[len];
        int j=0;
        for (int i=0; i< record.length; i++) {
            String behavior = record[i].split(" ")[0];
            String nick = users.get(record[i].split(" ")[1]);
            if(behavior.equals("Enter")){
                answer[j++] = nick+"님이 들어왔습니다.";
            } else if(behavior.equals("Leave")) {
                answer[j++] = nick+"님이 나갔습니다.";
            }
        }
        System.out.println(answer.length);
        for (String s : answer) {
            System.out.println(s);
        }

    }
}
