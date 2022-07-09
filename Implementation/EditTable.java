import java.util.*;

public class EditTable {
    public static void main(String[] args) {
        int n = 8;
        int k = 2; // 처음 선택된 행
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        System.out.println(solution(n, k, cmd));
    }

    private static String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            nodes[i].left = nodes[i - 1];
            nodes[i - 1].right = nodes[i];
        }

        Stack<Node> stack = new Stack<>();
        Node cur = nodes[k];

        for (String s : cmd) {
            if (s.equals("C")) {
                cur.removed = true;
                stack.push(cur);

                if (cur.left != null) {
                    cur.left.right = cur.right;
                }
                if (cur.right != null) {
                    cur.right.left = cur.left;
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            } else if (s.equals("Z")) {
                Node recoveryNode = stack.pop();
                recoveryNode.removed = false;
                if (recoveryNode.left != null) {
                    recoveryNode.left.right = recoveryNode;
                }

                if (recoveryNode.right != null) {
                    recoveryNode.right.left = recoveryNode;
                }
            } else {
                char c = s.charAt(0);
                String m = s.split(" ")[1];
                int move = Integer.parseInt(m);
                if (c == 'U') { // -
                    for (int i = 0; i < move; i++) {
                        cur = cur.left;
                    }

                } else { // 'D'  // +
                    for (int i = 0; i < move; i++) {
                        cur = cur.right;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (Node node : nodes) {
            if (node.removed) {
                sb.append('X');
            } else {
                sb.append('O');
            }
        }

        return sb.toString();
    }


    private static class Node {
        Node left, right;
        boolean removed;
    }
}
