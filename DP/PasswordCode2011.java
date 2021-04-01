import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PasswordCode2011 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine();
        int[]d = new int[p.length()+1];
        d[0]=1;
        d[1]=1;
        boolean check=true;
        if(p.charAt(0)=='0')
            check=false;
        if(p.length()>=2){

            for(int i=1; i<p.length(); i++){
                if(p.charAt(0)=='0'){
                    check=false;
                    break;
                }
                if(p.charAt(i)=='0'){
                    if(p.charAt(i-1)!='1' && p.charAt(i-1)!='2'){
                        check=false;
                        break;
                    }
                }
                if(p.charAt(i-1)=='1'){
                    if(p.charAt(i)!='0'){
                        d[i+1]= (d[i]+d[i-1])%1000000;
                    } else{
                        d[i+1] = d[i-1]%1000000;
                    }

                } else if(p.charAt(i-1)=='2'){
                    if(p.charAt(i)-'0'<=6 && p.charAt(i)!='0'){
                        d[i+1]=(d[i]+d[i-1])%1000000;
                    } else{
                        d[i+1] = d[i-1]%1000000;
                    }
                } else{
                    d[i+1] = d[i]%1000000;
                }
            }
        }
        if(check)
            System.out.println(d[p.length()]);
        else
            System.out.println(0);
    }
}
//안되는 경우의 수가 많다. 잘 생각하자
//입력이 0, 10, 3001 일 때 등 0이 들어갔을 때를 잘 생각!
