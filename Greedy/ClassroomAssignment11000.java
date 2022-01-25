import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ClassroomAssignment11000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ClassTime[] arr = new ClassTime[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new ClassTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr); //시작시간 오름차순으로 정렬. 같으면 끝나는 시간 오름차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //end 만 pq에 넣음.
        pq.offer(arr[0].end);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i].start) { //pq에서 가장 작은 종료시간과 arr의 시작시간을 비교함.
                pq.poll();
            }
            pq.offer(arr[i].end);
        }
        
        System.out.println(pq.size()); //pq에 있는건 한 강의실에서의 마지막 수업시간.

    }

    static class ClassTime implements Comparable<ClassTime> {
        int start, end;

        public ClassTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ClassTime o) { //시작시간 순으로 오름차순 정렬. 끝나는 시간으로 먼저 정렬하면 안됨. 반례있음.
            if (o.start == this.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }
}
