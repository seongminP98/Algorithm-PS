import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RomanNum2608 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n1 = br.readLine();
        String n2 = br.readLine();
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<n1.length(); i++){
            if(n1.charAt(i)=='I'){
                if(i<n1.length()-1){
                    if(n1.charAt(i+1)=='V'){
                        sum1 += 4;
                        i++;
                    }else if(n1.charAt(i+1)=='X'){
                        sum1 += 9;
                        i++;
                    }else{
                        sum1+=1;
                    }
                } else{
                    sum1 += 1;
                }
            }
            else if(n1.charAt(i)=='V'){
                sum1 += 5;
            }
            else if(n1.charAt(i)=='X'){
                if(i<n1.length()-1){
                    if(n1.charAt(i+1)=='L'){
                        sum1 += 40;
                        i++;
                    }else if(n1.charAt(i+1)=='C'){
                        sum1 += 90;
                        i++;
                    }else{
                        sum1 += 10;
                    }
                }else{
                    sum1 += 10;
                }
            }
            else if(n1.charAt(i)=='L'){
                sum1 += 50;
            }
            else if(n1.charAt(i)=='C'){
                if(i<n1.length()-1){
                    if(n1.charAt(i+1)=='D'){
                        sum1 += 400;
                        i++;
                    }else if(n1.charAt(i+1)=='M'){
                        sum1 += 900;
                        i++;
                    } else{
                        sum1 += 100;
                    }
                } else{
                    sum1 += 100;
                }
            }
            else if(n1.charAt(i)=='D'){
                sum1 += 500;
            }
            else if(n1.charAt(i)=='M'){
                sum1 += 1000;
            }
            //System.out.println("I: "+i+"  sum:"+sum1);
        }

        for(int i=0; i<n2.length(); i++){
            if(n2.charAt(i)=='I'){
                if(i<n2.length()-1){
                    if(n2.charAt(i+1)=='V'){
                        sum1 += 4;
                        i++;
                    }else if(n2.charAt(i+1)=='X'){
                        sum2 += 9;
                        i++;
                    }else{
                        sum2+=1;
                    }
                } else{
                    sum2 += 1;
                }
            }
            else if(n2.charAt(i)=='V'){
                sum2 += 5;
            }
            else if(n2.charAt(i)=='X'){
                if(i<n2.length()-1){
                    if(n2.charAt(i+1)=='L'){
                        sum2 += 40;
                        i++;
                    }else if(n2.charAt(i+1)=='C'){
                        sum2 += 90;
                        i++;
                    }else{
                        sum2 += 10;
                    }
                }else{
                    sum2 += 10;
                }
            }
            else if(n2.charAt(i)=='L'){
                sum2 += 50;
            }
            else if(n2.charAt(i)=='C'){
                if(i<n2.length()-1){
                    if(n2.charAt(i+1)=='D'){
                        sum2 += 400;
                        i++;
                    }else if(n2.charAt(i+1)=='M'){
                        sum2 += 900;
                        i++;
                    } else{
                        sum2 += 100;
                    }
                } else{
                    sum2 += 100;
                }
            }
            else if(n2.charAt(i)=='D'){
                sum2 += 500;
            }
            else if(n2.charAt(i)=='M'){
                sum2 += 1000;
            }
        }
        System.out.println(sum1+sum2);
        int sum = sum1+sum2;
        String ans = "";



        while(sum>0){
            if(sum>=1000){
                sum -= 1000;
                ans+="M";
            }
            else if(sum>=900){
                sum -= 900;
                ans+="CM";
            }
            else if(sum>=500){
                sum -= 500;
                ans+="D";
            }
            else if(sum>=400){
                sum-=400;
                ans+="CD";
            }
            else if(sum>=100){
                sum-=100;
                ans+="C";
            }
            else if(sum>=90){
                sum-=90;
                ans+="XC";
            }
            else if(sum>=50){
                sum-=50;
                ans+="L";
            }
            else if(sum>=40){
                sum-=40;
                ans+="XL";
            }
            else if(sum>=10){
                sum-=10;
                ans+="X";
            }
            else if(sum>=9){
                sum-=9;
                ans+="IX";
            }
            else if(sum>=5){
                sum-=5;
                ans+="V";
            }
            else if(sum>=4){
                sum-=4;
                ans+="IV";
            }
            else if(sum>=1){
                sum-=1;
                ans+="I";
            }
        }
        System.out.println(ans);
    }
}
