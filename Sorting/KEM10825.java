import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class KEM10825 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][4];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                arr[i][j] = st.nextToken();
            }
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(Integer.parseInt(o1[1])==Integer.parseInt(o2[1])){ //1 국어 점수가 같을 때
                    if(Integer.parseInt(o1[2])==Integer.parseInt(o2[2])){ //2 국영 점수가 같을 때
                        if(Integer.parseInt(o1[3])==Integer.parseInt(o2[3])){ //3 국영수 점수가 같을 때
                            return o1[0].compareTo(o2[0]); //3 이름 오름차순
                        }
                        return Integer.compare(Integer.parseInt(o2[3]),Integer.parseInt(o1[3]));//2 수학 내림차순
                    }
                    return Integer.compare(Integer.parseInt(o1[2]),Integer.parseInt(o2[2]));//1 영어 오름차순
                } else{
                    return Integer.compare(Integer.parseInt(o2[1]),Integer.parseInt(o1[1]));// 국어 내림차순
                }
            }
        });
        for(int i=0; i<N; i++){
            System.out.println(arr[i][0]);
        }
    }
}
