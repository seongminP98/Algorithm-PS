import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Ecology4358 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        int num = 0;
        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
            num++;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet()) {
            double rate = map.get(s) / (double)num * 100;
//            rate = Math.round(rate * 10000) / 10000.0; //왜 이렇게하면 안되지..?
            sb.append(s).append(" ").append(String.format("%.4f", rate)).append('\n');
        }
        System.out.print(sb);
    }
}
