import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NewRecruits1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Applicant> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list); //서류 성적순으로 정렬
            
            int answer = 1; //서류 1등은 무조건 합격. //(면접 1등도 무조건 합격)
            int min = list.get(0).itv;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).itv < min) {
                    answer++;
                    min = list.get(i).itv;
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    static class Applicant implements Comparable<Applicant> {
        int doc, itv;

        public Applicant(int doc, int itv) {
            this.doc = doc;
            this.itv = itv;
        }

        @Override
        public int compareTo(Applicant o) {
            return this.doc > o.doc ? 1 : -1;
        }
    }
}
