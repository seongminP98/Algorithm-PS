import java.util.*;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {50, 5}};
        System.out.println(solution(jobs));
    }

    static int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        for (int[] job : jobs) {
            pq.add(new Job(job[0], job[1]));
        }
        int time = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            if (pq.peek().start <= time) {
                List<Job> tmp = new ArrayList<>();
                tmp.add(pq.poll());
                while (!pq.isEmpty()) {
                    if (pq.peek().start <= time) {
                        tmp.add(pq.poll());
                    } else {
                        break;
                    }
                }
                tmp.sort((o1, o2) -> {
                    return Integer.compare(o1.time, o2.time);
                });
                Job c = tmp.remove(0);
                pq.addAll(tmp);
                answer += (c.time + time - c.start); // 들어온 시간부터 걸린 시간까지 
                time += c.time; // 현재시간
            } else {
                time++;
            }
        }

        return answer / jobs.length;

    }

    static class Job implements Comparable<Job> {
        int start, time;

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", time=" + time +
                    '}';
        }

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Job o) {
            if (start == o.start) {
                return Integer.compare(time, o.time);
            }
            return Integer.compare(start, o.start);
        }
    }

}
