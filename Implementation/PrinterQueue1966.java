import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PrinterQueue1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int find = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[N];
            st = new StringTokenizer(br.readLine());
            List<Document> doc = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                doc.add(new Document(i, num));
            }
            Arrays.sort(arr, Collections.reverseOrder());

            int i=0;
            int answer = 1;
            while(i<N) {
                if(arr[i] == doc.get(0).num) {
                    if(find == doc.get(0).index) {
                        System.out.println(answer);
                        break;
                    } else {
                        answer++;
                        doc.remove(0);
                        i++;
                    }
                } else {
                    Document d = new Document(doc.get(0).index, doc.get(0).num);
                    doc.remove(0);
                    doc.add(d);
                }
            }
        }
    }

    static class Document {
        int index, num;

        public Document(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
