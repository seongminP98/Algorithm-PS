import java.util.*;

public class TravelRoute {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        Arrays.sort(tickets, Comparator.comparing(o -> o[1])); // index 1 기준으로 정렬
        boolean[] visited = new boolean[tickets.length];

        String[] answer = new String[tickets.length + 1];
        String[] temp = new String[tickets.length + 1];
        temp[0] = "ICN";
        dfs(tickets, "ICN", 1, answer, visited, temp);
        for (String s : answer) {
            System.out.print(s + " ");
        }
    }

    static void dfs(String[][] tickets, String c, int idx, String[] answer, boolean[] visited, String[] temp) {
        if (idx == tickets.length + 1) {
            if (answer[0] != null) {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].compareTo(answer[i]) < 0) { // 알파벳 순서가 앞서는 경우가 아니면 리턴
                        return;
                    }
                }
            }
            System.arraycopy(temp, 0, answer, 0, temp.length); // answer 이 null 이거나, 이번에 확인한게 알파벳 순서로 앞서는 경우
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(c)) {
                temp[idx] = tickets[i][1];
                visited[i] = true;
                dfs(tickets, tickets[i][1], idx + 1, answer, visited, temp);
                visited[i] = false;
            }
        }
    }
}
