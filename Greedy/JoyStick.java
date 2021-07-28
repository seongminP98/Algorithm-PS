import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JoyStick {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int answer = 0;
        int min = name.length()-1; //이동할 거리의 최대 값.
        for(int i=0; i<name.length(); i++){
            int check = i+1;
            if(name.charAt(i)!=65) {
                answer += Math.min(name.charAt(i) - 65, 90 - name.charAt(i) + 1);;
            }

            while(check<name.length() && name.charAt(check) == 'A') {
                check++;
            }

            min = Math.min(min, i+i+name.length()-check); //이동한 거리.
            /**
             * i : 현재위치까지 이동한거리. 두번째 i : 처음위치로 되돌아간 거리.
             * name.length()-check : 연속된 A가 있어 뒤로가는게 빠른경우 뒤로가는 거리.
             */
        }
        answer+=min;
        System.out.println(answer);
    }
}
