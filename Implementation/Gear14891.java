import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gear14891 {
    static List<Integer> gear1;
    static List<Integer> gear2;
    static List<Integer> gear3;
    static List<Integer> gear4;

    public static void main(String[] args) throws Exception {
        gear1 = new ArrayList<>();
        gear2 = new ArrayList<>();
        gear3 = new ArrayList<>();
        gear4 = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (i == 0)
                    gear1.add(s.charAt(j) - '0');
                else if (i == 1)
                    gear2.add(s.charAt(j) - '0');
                else if (i == 2)
                    gear3.add(s.charAt(j) - '0');
                else gear4.add(s.charAt(j) - '0');
            }
        }


        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken()); //1이면 시계방향, -1이면 반시계방향
            if (num == 1) {
                boolean check = comparePole(gear1, gear2);
                rotationGear(dir, gear1);
                if (!check) {
                    boolean check2 = comparePole(gear2, gear3);
                    rotationGear(-1 * dir, gear2);
                    if (!check2) {
                        boolean check3 = comparePole(gear3, gear4);
                        rotationGear(dir, gear3);
                        if (!check3) {
                            rotationGear(-1 * dir, gear4);
                        }
                    }
                }
            } else if (num == 2) {
                boolean check = comparePole(gear1, gear2);

                if (!check) {
                    rotationGear(-1 * dir, gear1);
                }
                boolean check2 = comparePole(gear2, gear3);
                if (!check2) {
                    boolean check3 = comparePole(gear3, gear4);
                    rotationGear(-1 * dir, gear3);

                    if (!check3) {
                        rotationGear(dir, gear4);
                    }
                }
                rotationGear(dir, gear2);
            } else if (num == 3) {
                boolean check = comparePole(gear3, gear4);
                if (!check) {
                    rotationGear(-1 * dir, gear4);
                }
                boolean check2 = comparePole(gear2, gear3);
                if (!check2) {
                    boolean check3 = comparePole(gear1, gear2);
                    rotationGear(-1 * dir, gear2);

                    if (!check3) {
                        rotationGear(dir, gear1);
                    }
                }
                rotationGear(dir, gear3);
            } else { //num == 4
                boolean check = comparePole(gear3, gear4);
                rotationGear(dir, gear4);
                if (!check) {
                    boolean check2 = comparePole(gear2, gear3);
                    rotationGear(-1 * dir, gear3);
                    if (!check2) {
                        boolean check3 = comparePole(gear1, gear2);
                        rotationGear(dir, gear2);
                        if (!check3) {
                            rotationGear(-1 * dir, gear1);
                        }
                    }
                }
            }

        }

        int sum = 0;
        if (gear1.get(0).equals(1))
            sum += 1;
        if (gear2.get(0).equals(1))
            sum += 2;
        if (gear3.get(0).equals(1))
            sum += 4;
        if (gear4.get(0).equals(1))
            sum += 8;

        System.out.println(sum);
    }

    static void rotationGear(int dir, List<Integer> gear) {
        if (dir == 1) {
            Integer last = gear.get(7);
            gear.remove(7);
            gear.add(0, last);
        } else {
            Integer first = gear.get(0);
            gear.remove(0);
            gear.add(first);
        }
    }

    static boolean comparePole(List<Integer> leftGear, List<Integer> rightGear) {
        return leftGear.get(2).equals(rightGear.get(6));
    }
}
