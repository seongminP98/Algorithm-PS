import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Rumor19538 {
    static int N, M;
    static List<List<Integer>> list; // 주변인
    //    static List<Integer> first;
    static Set<Integer> set;
    static int[] answer;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) break;
                list.get(i).add(num);
            }
        }

        set = new HashSet<>();
//        first = new ArrayList<>();
        M = Integer.parseInt(br.readLine());
        answer = new int[N + 1];
        check = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            answer[num] = 0;
            check[num] = true;
        }
//        for(int i=1; i<=N; i++) {
//
//        }
        bfs();
        for(int i=1; i<=N; i++) {
            System.out.print(answer[i]+" ");
        }


    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>(set);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            while (size-- > 0) {
                int c = q.poll();
//                set.add(c);
                System.out.println();
                System.out.println("c = " + c);
                // c는 루머를 들었던 사람. 믿는지 안믿는지 체크해줘야 함.
                if(check[c]) { // 루머 믿음
                    System.out.println("루머믿음");
                    for (Integer friend : list.get(c)) { // 퍼뜨림
                        System.out.println("friend = " + friend);

                        if(!set.contains(friend)) { // 루머를 안들은 사람들
//                            answer[friend] = time;
                            System.out.println("2friend = " + friend);
                            q.add(friend);
                            set.add(friend);
                        }
                    }
                } else { // 루머 안믿는 사람
                    System.out.println("루머 안믿음");
                    int believerNum = 0;
                    for (Integer friend : list.get(c)) {
                        if(check[friend]) {
                            believerNum++;
                        }
                    }
                    if(believerNum >= list.get(c).size()/2) { // 루머 믿음
                        System.out.println("이제 루머 믿음");
                        check[c] = true;
                        answer[c] = time;

                        for (Integer friend : list.get(c)) {
//                            System.out.println("friend = " + friend);

                            if(!set.contains(friend)) { // 루머를 안들은 사람들
//                            answer[friend] = time;
//                                System.out.println("2friend = " + friend);
                                q.add(friend);
                                set.add(friend);
                            }
                        }

                    }
                }

            }
        }
    }
}
