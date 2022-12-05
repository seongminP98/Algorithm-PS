import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryJBNU12757 {
    static TreeMap<Integer, Integer> map;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new TreeMap<>();
        map.put(-1_000_000_000, -1);
        map.put(1_000_000_001, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) { // 추가
                map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else if (cmd == 2) { // value 변경
                int key = searchKey(Integer.parseInt(st.nextToken()));
                if (key < 0) continue;
                map.put(key, Integer.parseInt(st.nextToken()));
            } else { // 출력
                int key = searchKey(Integer.parseInt(st.nextToken()));
                if (key == -2) {
                    System.out.println("?");
                } else if (key == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(map.get(key));
                }
            }
        }
    }

    private static int searchKey(int key) {
        int right = map.ceilingKey(key);
        int left = map.floorKey(key);

        if (right == key && left == key) {
            return key;
        } else if (right - key == key - left && right - key <= K) { // 2개 이상 존재
            return -2;
        } else if (right - key < key - left && right - key <= K) {
            return right;
        } else if (right - key > key - left && key - left <= K) {
            return left;
        } else { // 존재 안함
            return -1;
        }
    }
}
