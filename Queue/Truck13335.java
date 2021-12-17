import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Truck13335 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); //다리의 길이
        int L = Integer.parseInt(st.nextToken()); //최대하중

        Queue<Truck> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            q.add(new Truck(weight, 1));
        }
        List<Truck> list = new ArrayList<>();
        int result = 0;
        int sumW = 0; //다리 위 트럭의 무게 합
        int sumN = 0; //다리 위 트럭의 개수
        int check = 0;
        while(true) {
            result++;
            for(int i=0; i<list.size(); i++) {
                if(i==0 && list.get(0).pos == w) {
                    sumN--;
                    sumW -= list.get(0).weight;
                    list.remove(0);
                    check++;
                }
                if(list.size() != 0)
                    list.get(i).pos++;
            }

            if(!q.isEmpty()) {
                Truck cTruck = q.peek();
                if(sumW + cTruck.weight <= L && sumN<=w) {
                    sumW += cTruck.weight;
                    sumN++;
                    list.add(q.poll());
                }
            }
            if(check == n) {
                break;
            }
        }
        System.out.println(result);
    }
    static class Truck{
        int weight, pos;

        public Truck(int weight, int pos) {
            this.weight = weight;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "weight=" + weight +
                    ", pos=" + pos +
                    '}';
        }
    }
}
