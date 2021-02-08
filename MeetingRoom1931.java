import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoom1931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() { //끝나는시간으로 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) { //종료시간이 같으면 시작 빠른순으로 정렬.
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int t = time[0][1];
        for(int i=1; i<n; i++){
            if(time[i][0]>=t){
                count++;
                t = time[i][1];
            }
        }
        System.out.println(count);
    }
}
