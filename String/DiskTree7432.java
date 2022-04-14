import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class DiskTree7432 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node rootNode = new Node();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("\\\\");
            insert(str, rootNode); // 루트부터 시작
        }

        print(rootNode, 0);
        System.out.println(sb);
    }

    static void insert(String[] str, Node node) {
        for (String s : str) {
            if (!node.childNode.containsKey(s)) { // 내 자식에 포함되어 있지 않으면
                node.childNode.put(s, new Node()); // 자식으로 추가함.
            }
            node = node.childNode.get(s); // 자식으로 넘어감.
        }
    }

    static void print(Node node, int cnt) {
        for (String key : node.childNode.keySet()) { // 자식의 keySet 을 돌면서
            sb.append(" ".repeat(Math.max(0, cnt))); // cnt 만큼 앞에 공백 추가
            sb.append(key).append('\n');
            print(node.childNode.get(key), cnt + 1);
        }
    }

    static class Node {
        Map<String, Node> childNode = new TreeMap<>();
    }
}
