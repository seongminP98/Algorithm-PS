import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Puzzle1525 {
    static int start;
    static HashMap<Integer,Integer> count = new HashMap<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        start = 0;
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n==0)
                    n=9;
                start = (start*10)+n; //2차원 배열을 숫자 하나로 바꿈. 0은9로 바꿈.
            }
        }
        bfs();
        if(count.containsKey(123456789)){
            System.out.println(count.get(123456789));
        } else
            System.out.println(-1);

    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        count.put(start,0);
        q.add(start);
        while(!q.isEmpty()){
            int temp = q.poll();
            String s = Integer.toString(temp);
            int index = s.indexOf("9"); //9가 있는 index 찾기
            int x = index/3; //9가있는 row의 위치
            int y = index%3; //9가있는 column의 위치
            for(int i=0; i<4; i++){
                int nx = x+dx[i]; //새로운 row의 위치
                int ny = y+dy[i]; //새로운 column의 위치
                int nIndex = nx*3+ny; //새로운 index의 위치
                if(nx>=0 && ny>=0 && nx<3 && ny<3){
                    StringBuilder next = new StringBuilder(s);
                    char tmp = s.charAt(nIndex); //9와 바꿀 숫자. (9가 이동할 위치의 숫자)
                    next.setCharAt(nIndex,'9'); //9 이동.
                    next.setCharAt(index,tmp); //9가 이동한 자리에 있던 숫자는 9가 원래 있던 곳으로 이동.
                    int nextNum = Integer.parseInt(next.toString());
                    if(!count.containsKey(nextNum)){
                        count.put(nextNum,count.get(temp)+1);
                        q.add(nextNum);
                    }
                }
            }
        }
    }
}
