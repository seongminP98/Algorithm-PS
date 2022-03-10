import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) {
        int N = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        int[] dis = new int[N + 1];
        dis[1] = 1;
        int max = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Integer next : list.get(node)) {
                if (dis[next] == 0) {
                    dis[next] = dis[node] + 1;
                    max = dis[next];
                    q.add(next);
                }
            }
        }
        int answer = 0;
        for (int d : dis) {
            if (d == max) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
/*
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static ArrayList<ArrayList<Integer>> list;
    public int solution(int N, int[][] edge) {
        list = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i< edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        int[] dis = new int[N+1];
        dis[1] = 1;
        int max = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) {
            int node = q.poll();
            for (Integer next : list.get(node)) {
                if(dis[next] == 0) {
                    dis[next] = dis[node] + 1;
                    max = dis[next];
                    q.add(next);
                }
            }
        }
        int answer = 0;
        for (int d : dis) {
            if(d == max) {
                answer++;
            }
        }
        return answer;
    }
}
 */
