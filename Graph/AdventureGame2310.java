import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AdventureGame2310 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        loop:
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            Room[] rooms = new Room[n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                char type = st.nextToken().charAt(0);
                int money = Integer.parseInt(st.nextToken());
                List<Integer> next = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num != 0) {
                        next.add(num);
                    }
                }
                rooms[i] = new Room(type, money, next);
            }
            int[] visited = new int[n + 1];
            Arrays.fill(visited, -1);

            Queue<Adventurer> q = new LinkedList<>();
            if (rooms[1].type == 'E') {
                q.add(new Adventurer(1, 0));
                visited[1] = 0;
            }
            while (!q.isEmpty()) {
                Adventurer c = q.poll();
                if (c.num == n) {
                    sb.append("Yes").append('\n');
                    continue loop;
                }
                for (Integer nextRoom : rooms[c.num].next) {
                    if (visited[nextRoom] < c.money) { // 현재 금액으로 방문 안했으면 방문 함
                        if (rooms[nextRoom].type == 'T') { // 트롤
                            if (rooms[nextRoom].money <= c.money) { // 들어갈 수 있으면
                                visited[nextRoom] = c.money;
                                q.add(new Adventurer(nextRoom, c.money - rooms[nextRoom].money));
                            }
                        } else { // 레프리콘 or 빈방
                            if (rooms[nextRoom].money > c.money) { // 돈 채움
                                visited[nextRoom] = rooms[nextRoom].money;
                                q.add(new Adventurer(nextRoom, rooms[nextRoom].money));
                            } else { // 이미 돈 꽉참
                                visited[nextRoom] = c.money;
                                q.add(new Adventurer(nextRoom, c.money));
                            }
                        }
                    }
                }
            }

            sb.append("No").append('\n');
        }
        System.out.print(sb);
    }

    static class Adventurer {
        int num, money;

        public Adventurer(int num, int money) {
            this.num = num;
            this.money = money;
        }

        @Override
        public String toString() {
            return "Adventurer{" +
                    "num=" + num +
                    ", money=" + money +
                    '}';
        }
    }

    static class Room {
        char type;
        int money;
        List<Integer> next;

        public Room(char type, int money, List<Integer> next) {
            this.type = type;
            this.money = money;
            this.next = next;
        }
    }
}
