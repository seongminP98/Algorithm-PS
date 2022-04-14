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
            insert(str, rootNode);
        }

        print(rootNode, 0);
        System.out.println(sb);
    }

    static void insert(String[] str, Node node) {
        for (String s : str) {
            if (node.childNode.containsKey(s)) {
                node = node.childNode.get(s);
                node.end = false;
            } else {
                node.childNode.put(s, new Node());
                node = node.childNode.get(s);
                node.end = true;
            }
        }
    }

    static void print(Node node, int cnt) {

        for (String key : node.childNode.keySet()) {
            sb.append(" ".repeat(Math.max(0, cnt)));
            sb.append(key).append('\n');
            print(node.childNode.get(key), cnt + 1);
        }

    }

    static class Node {
        Map<String, Node> childNode = new TreeMap<>();
        boolean end;
    }
}
