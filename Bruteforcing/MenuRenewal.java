import java.util.*;

public class MenuRenewal {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
        //result = "ACD", "AD", "ADE", "CD", "XYZ"
        for (String order : orders) {
            for (int i : course) {
                if (order.length() >= i) {
                    char[] arr = order.toCharArray();
                    Arrays.sort(arr);
                    combination(arr, new boolean[arr.length], 0, i);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i : course) {
            int max = 0;
            for (String s : map.keySet()) {
                if (s.length() == i) {
                    max = Math.max(map.get(s), max);
                }
            }
            if (max <= 1)
                continue;

            for (String s : map.keySet()) {
                if (s.length() == i && map.get(s) == max) {
                    list.add(s);
                }
            }
        }
        Collections.sort(list);
        String[] answer = list.toArray(new String[0]);
        for (String s : answer) {
            System.out.println(s);
        }

    }

    static void combination(char[] arr, boolean[] visited, int start, int depth) {
        if (depth == 0) {
            StringBuilder order = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    order.append(arr[i]);
                }
            }
            map.put(order.toString(), map.getOrDefault(order.toString(), 0) + 1);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, depth - 1);
            visited[i] = false;
        }
    }
}
