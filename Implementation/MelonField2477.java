import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MelonField2477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Field[] field = new Field[6];
        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            field[i] = new Field(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (field[i].dir == 1)
                east++;
            else if (field[i].dir == 2) {
                west++;
            } else if (field[i].dir == 3) {
                south++;
            } else {
                north++;
            }
        }
        int maxW = 0;
        int maxL = 0;
        int indexW = 0;
        int indexL = 0;
        for (int i = 0; i < field.length; i++) {
            if (east < west) {
                if (field[i].dir == 1) {
                    maxW = field[i].dis;
                    indexW = i;
                }
            } else {
                if (field[i].dir == 2) {
                    maxW = field[i].dis;
                    indexW = i;
                }
            }
            if (south < north) {
                if (field[i].dir == 3) {
                    maxL = field[i].dis;
                    indexL = i;
                }
            } else {
                if (field[i].dir == 4) {
                    maxL = field[i].dis;
                    indexL = i;
                }
            }
        }
        int divW = 0;
        int divL = 0;
        if (indexW == 0) {
            divL = Math.abs(field[1].dis - field[5].dis);
        } else if (indexW == 5) {
            divL = Math.abs(field[0].dis - field[4].dis);
        } else {
            divL = Math.abs(field[indexW - 1].dis - field[indexW + 1].dis);
        }

        if (indexL == 0) {
            divW = Math.abs(field[1].dis - field[5].dis);
        } else if (indexL == 5) {
            divW = Math.abs(field[0].dis - field[4].dis);
        } else {
            divW = Math.abs(field[indexL - 1].dis - field[indexL + 1].dis);
        }
        int answer = maxW * maxL - divL * divW;
        System.out.println(answer * K);
    }

    static class Field {
        int dir, dis;

        public Field(int dir, int dis) {
            this.dir = dir;
            this.dis = dis;
        }
    }
}
