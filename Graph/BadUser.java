import java.util.*;

public class BadUser {
    static int size;
    static List<ArrayList<String>> list;
    static List<TreeSet<String>> temp;
    static int idx = 0;

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        size = banned_id.length;
        list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
            for (String user : user_id) {
                if (equal(banned_id[i], user)) {
                    list.get(i).add(user);
                }
            }
        }
/*
        for (ArrayList<String> arrayList : list) {
            for (String s : arrayList) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
        System.out.println("=======================");
*/

        temp = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        int maxSize = 1;
        for (ArrayList<String> arrayList : list) {
            maxSize *= arrayList.size();
        }
        for (int i = 0; i <= maxSize; i++) {
            temp.add(new TreeSet<>());
        }
        dfs(0, visited);

/*
        for (TreeSet<String> strings : temp) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
*/

        int answer = idx;
        for (int i = 0; i < idx - 1; i++) {
            for (int j = i + 1; j < idx; j++) {
                if (equalList(temp.get(i), temp.get(j))) {
                    answer--;
                    break;
                }

            }
        }
        System.out.println(answer);

    }

    static boolean equalList(TreeSet<String> list1, TreeSet<String> list2) {
        for (String s : list1) {
            if (!list2.contains(s)) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int depth, Set<String> visited) {
        if (depth == size) {
            for (String s : visited) {
                temp.get(idx).add(s);
            }
            idx++;
            return;
        }
        for (String s : list.get(depth)) {
            if (!visited.contains(s)) {
                visited.add(s);
                dfs(depth + 1, visited);
                visited.remove(s);
            }
        }

    }


    static boolean equal(String ban, String user) { // ban_id 에 맞는 user_id 확인
        if (ban.length() != user.length()) {
            return false;
        }
        int size = ban.length();
        for (int i = 0; i < size; i++) {
            if (ban.charAt(i) == '*') {
                continue;
            }
            if (ban.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
