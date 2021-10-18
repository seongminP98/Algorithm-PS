import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevMatching2 {
    static int max = 0;
    static boolean[] calender;
    public static void main(String[] args) {
        int leave = 7;
        String day = "SUN";
        int[] holiday = {1,2,3,4,5,6,7,8,9,10,11,21,22,23,24,25,26};

        calender = new boolean[31];

        Map<String, Integer> map = new HashMap<>();
        map.put("MON",5);
        map.put("TUS",4);
        map.put("WED",3);
        map.put("THU",2);
        map.put("FRI",1);
        map.put("SAT",0);
        map.put("SUN",6);

        for (int i : holiday) {
            calender[i] = true;
        }
        int num = map.get(day);
        int  start = 1;
        while (true) {
            if(start+num>30)
                break;
            calender[start+num] = true;
            if(start+num+1>30)
                break;
            calender[start+num+1] = true;
            start += 7;
        }
        if(day.equals("SUN")){
            calender[1] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int i=1; i<calender.length; i++) {
            if(!calender[i]) {
                list.add(i);
            }
        }
        if(list.size()<=leave) {
            System.out.println(30);
            System.exit(0);
        }
        boolean[] visited = new boolean[list.size()];
        combi(visited, list, 0, list.size(), leave);
        System.out.println("max = " + max);

    }
    static int length(boolean[] arr) {
        int max = 0;
        int len = 0;
        for(int i=1; i<arr.length; i++) {
            if(arr[i]) {
                len++;
            } else {
                max = Math.max(max,len);
                len = 0;
            }
        }
        max = Math.max(max,len);
        return max;
    }
    static void combi(boolean[] visited, List<Integer> list, int start, int n, int r) {
        if(r==0) {
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    calender[list.get(i)] = true;
                }
            }
            max = Math.max(length(calender),max);
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    calender[list.get(i)] = false;
                }
            }
            return;
        }

        for(int i = start; i<n; i++) {
            visited[i] = true;
            combi(visited, list, i+1, n, r-1);
            visited[i] = false;
        }
    }
}
