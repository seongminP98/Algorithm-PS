import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoboticVacuum14503 {
    static int N, M;
    static int r,c,d;
    static int[][] area;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        area = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 1;
        area[r][c]=2;
        int count = 0;

        while(true) {
            int nr,nc;
            if(d==0) { //왼쪽방향으로 회전
                d=3;
            } else{
                d-=1;
            }
            nr = r+dx[d];
            nc = c+dy[d];
            if(check(nr,nc) && area[nr][nc]==0) { //다음 진행할 방향이 빈칸이면 진행하고 청소.
                r=nr;
                c=nc;
                area[r][c] = 2;
                answer++;
                count=0;

            } else { //다음 진행할 방향이 청소되었거나 벽인 경우.
                if(count==4) { //4방향 모두 청소되었거나 벽인경우에 후진.
                    //오른쪽방향으로 회전. (왼쪽으로 회전한 상태기 때문에 오른쪽으로 회전 한번해주고 후진)
                    if(d==3) {
                        d=0;
                    } else{
                        d+=1;
                    }
                    //후진.
                    if(d==0) {
                        r=r+dx[2];
                        c=c+dy[2];
                    }else if(d==1) {
                        r=r+dx[3];
                        c=c+dy[3];
                    }else if(d==2) {
                        r=r+dx[0];
                        c=c+dy[0];
                    }else if(d==3) {
                        r=r+dx[1];
                        c=c+dy[1];
                    }
                    count=0;

                    if(area[r][c] == 1) {
                        break;
                    }
                } else {
                    count++;
                }
            }
        }
        System.out.println(answer);
    }

    //범위 체크
    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
