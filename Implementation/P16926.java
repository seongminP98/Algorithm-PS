import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16926 {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int startX = 0;
        int startY = 0;
        int endX = N;
        int endY = M;
        for (int i = 0; i < R; i++) {
            while (startX < endX && startY < endY) {
                rotation(startX, startY, endX, endY);
                startX++;
                startY++;
                endX--;
                endY--;
            }
            startX = 0;
            startY = 0;
            endX = N;
            endY = M;
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static void rotation(int startX, int startY, int endX, int endY) {
        int temp = arr[startX][startY];
        for (int i = startX; i < endX - 1; i++) { //좌
            int tmp = arr[i + 1][startY];
            arr[i + 1][startY] = temp;
            temp = tmp;
        }
/*        System.out.println("=====================");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println("temp = " + temp);
        System.out.println("=====================");*/

        for (int i = startY; i < endY - 1; i++) {
            int tmp = arr[endX - 1][i + 1];
            arr[endX - 1][i + 1] = temp;
            temp = tmp;
        }
/*        System.out.println("=====================");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println("=====================");*/

        for (int i = endX - 1; i > startX; i--) {
            int tmp = arr[i - 1][endY - 1];
            arr[i - 1][endY - 1] = temp;
            temp = tmp;
        }
/*        System.out.println("=====================");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println("=====================");*/

        for (int i = endY - 1; i > startY; i--) {
            int tmp = arr[startX][i - 1];
            arr[startX][i - 1] = temp;
            temp = tmp;
        }
/*        System.out.println("=====================");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println("=====================");*/
    }
}
