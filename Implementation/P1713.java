import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1713 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int rcmCount = Integer.parseInt(br.readLine()); //총 추천 횟수
        List<Rcm> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rcmCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < list.size(); j++) {
                list.set(j, new Rcm(list.get(j).num, list.get(j).time + 1, list.get(j).count));
            }


            boolean check = false;
            if (list.size() < N) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).num == num) {
                        list.set(j, new Rcm(num, list.get(j).time + 1, list.get(j).count + 1));
                        check = true;
                    }
                }
                if (!check)
                    list.add(new Rcm(num, 1, 1));
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).num == num) {
                        list.set(j, new Rcm(num, list.get(j).time + 1, list.get(j).count + 1));
                        check = true;
                    }
                }
                if (!check) {
                    Collections.sort(list);
                    list.remove(0);
                    list.add(new Rcm(num, 1, 1));
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (Rcm rcm : list) {
            answer.add(rcm.num);
        }

        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }

    }

    static class Rcm implements Comparable<Rcm> {
        int num, time, count;

        public Rcm(int num, int time, int count) {
            this.num = num;
            this.time = time;
            this.count = count;
        }

        @Override
        public int compareTo(Rcm o) {
            if (o.count < this.count) {
                return 1;
            } else if (o.count == this.count) {
                if (o.time > this.time) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}
