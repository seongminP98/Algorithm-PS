import java.util.*;

public class TrainersConcern {
    public static void main(String[] args) {
        int n = 3;
        int m = 2;
//        int[][] timetable = {{1140, 1200}, {1150, 1200}, {1100, 1200}, {1210, 1300}, {1220, 1280}};
        int[][] timetable = {{1170, 1210}, {1200, 1260}};
        System.out.println(solution(n, m, timetable));
    }

    private static int solution(int n, int m, int[][] timetable) {
        int answer = 0;
        int maxPersonnel = 0;
        Arrays.sort(timetable, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        List<Integer> list = new ArrayList<>();
        for (int[] time : timetable) {
            list.removeIf(v -> (v < time[0]));
            list.add(time[1]);
            maxPersonnel = Math.max(maxPersonnel, list.size());
        }

        if (maxPersonnel == 1) return 0;
        if (maxPersonnel > n * n / 2) return 1;
        if (m == 2) return 2 * n - 2;

        for (int d = 2 * n - 3; d > 1; d--) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Set<Node> set = new HashSet<>();
                    set.add(new Node(i, j));
                    int tmp = 1;
                    for (int x = i; x < n; x++) {
                        for (int y = 0; y < n; y++) {
                            if (x < i || (x == i && y <= j)) continue; // 앞에 둘 필요가 없음.
                            boolean flag = false;
                            for (Node node : set) {
                                int distance = getDistance(node, new Node(x, y));
                                if (distance < d) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (!flag) {
                                set.add(new Node(x, y));
                                tmp++;
                            }
                            if (tmp == maxPersonnel) {
                                answer = d;
                                return answer;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    private static int getDistance(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

