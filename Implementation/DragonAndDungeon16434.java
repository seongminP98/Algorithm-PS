import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DragonAndDungeon16434 {
    static int N;
    static Room[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long attack = Long.parseLong(st.nextToken());
        arr = new Room[N]; // 타입 1: 몬스터 2: 포션, 공격력, 생명력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        long hp = 0;
        long maxHp = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i].t == 1) { //몬스터
                long hitCnt = (arr[i].h % attack == 0 ? arr[i].h / attack : arr[i].h / attack + 1) - 1;
                hp += hitCnt * arr[i].a; // 누적 데미지
                maxHp = Math.max(hp, maxHp);
            } else {
                attack += arr[i].a;
                hp = Math.max(hp - arr[i].h, 0); // 체력 회복은 누적 데미지에서 뺌.
            }
        }
        System.out.println(maxHp + 1);
/*이분탐색 사용.
        long right = 1000000000000L * N; // 최대값. 1000000*1000000 * N
        long left = 1;
        while (left <= right) {
            long maxH = (right + left) / 2;
            if (start(maxH, attack)) {
                right = maxH - 1;
            } else {
                left = maxH + 1;
            }
        }
        System.out.println(left);
*/
    }

    /*
        static boolean start(long maxH, long attack) {
            long hp = maxH;
            for (int i = 0; i < N; i++) {
                if (arr[i].t == 1) { // 몬스터
                    // 내가 맞는 횟수
                    long hitCnt = (arr[i].h % attack == 0 ? arr[i].h / attack : arr[i].h / attack + 1) - 1;
                    hp -= hitCnt * arr[i].a;
                    if (hp <= 0) { // 죽었음
                        return false;
                    }
                } else { // 포션
                    hp += arr[i].h;
                    hp = Math.min(hp, maxH);
                    attack += arr[i].a;
                }
            }
            return true;
        }
    */
    static class Room {
        int t, a, h;

        public Room(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
}
