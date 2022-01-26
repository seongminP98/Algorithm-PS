import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek13913 {
    static int subin, sister;
    static boolean[] visited = new boolean[100001];
    static int[] route = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(subin, 0));
        visited[subin] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int loc = node.location;
            int time = node.time;
            if (loc == sister) {

                sb.append(time).append("\n");
                Stack<Integer> stack = new Stack<>();
                while (loc != subin) {
                    stack.push(route[loc]);
                    loc = route[loc];
                }

                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }
                sb.append(sister);
                return;
            }
            int plusLoc = loc + 1;
            int minusLoc = loc - 1;
            int multiLoc = loc * 2;
            if (plusLoc >= 0 && plusLoc <= 100000 && !visited[plusLoc]) {
                q.add(new Node(plusLoc, time + 1));
                visited[plusLoc] = true;
                route[plusLoc] = loc;
            }
            if (minusLoc >= 0 && minusLoc <= 100000 && !visited[minusLoc]) {
                q.add(new Node(minusLoc, time + 1));
                visited[minusLoc] = true;
                route[minusLoc] = loc;
            }
            if (multiLoc >= 0 && multiLoc <= 100000 && !visited[multiLoc]) {
                q.add(new Node(multiLoc, time + 1));
                visited[multiLoc] = true;
                route[multiLoc] = loc;
            }

        }
    }

    static class Node {
        int location, time;

        public Node(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
}
