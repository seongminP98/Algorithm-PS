import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PaperCut2628 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = Integer.parseInt(br.readLine());
        List<Integer> width = new ArrayList<>();
        List<Integer> length = new ArrayList<>();
        for (int t = 0; t < count; t++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (dir == 0) {
                width.add(num);
            } else {
                length.add(num);
            }
        }
        width.add(M);
        length.add(N);
        Collections.sort(width);
        Collections.sort(length);

        int w = width.get(0);
        int l = length.get(0);
        for (int i = 1; i < width.size(); i++) {
            w = Math.max(width.get(i) - width.get(i - 1), w);
        }
        for (int i = 1; i < length.size(); i++) {
            l = Math.max(length.get(i) - length.get(i - 1), l);
        }
        System.out.println(w * l);

    }
}
