public class KeypadPress {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        String answer = "";
        Keypad left = new Keypad(3,0);
        Keypad right = new Keypad(3,2);
        for (int number : numbers) {
            if(number == 1 || number == 4 || number == 7) {
               answer += "L";
               if(number==1) {
                   left.position(0,0);
               } else if(number==4) {
                   left.position(1,0);
               } else if(number==7) {
                   left.position(2,0);
               }
            } else if(number == 3 || number == 6 || number == 9) {
                answer += "R";
                if(number==3) {
                    right.position(0,2);
                } else if(number==6) {
                    right.position(1,2);
                } else if(number==9) {
                    right.position(2,2);
                }
            } else {
                int i = 0;
                int j = 0;
                if(number == 2) {
                    i = 0;
                    j = 1;
                } else if(number == 5) {
                    i = 1;
                    j = 1;
                } else if(number == 8) {
                    i = 2;
                    j = 1;
                } else if(number == 0) {
                    i = 3;
                    j = 1;
                }
                int disL = Math.abs(i-left.i) + Math.abs(j-left.j);
                int disR = Math.abs(i-right.i) + Math.abs(j-right.j);
                if(hand.equals("right")) {
                    if(disL>=disR) {
                        answer += "R";
                        right.position(i,j);
                    } else {
                        answer += "L";
                        left.position(i,j);
                    }
                } else {
                    if(disR>=disL) {
                        answer += "L";
                        left.position(i,j);
                    } else {
                        answer += "R";
                        right.position(i,j);
                    }
                }
            }
        }
        System.out.println("answer = " + answer);
    }
    static class Keypad{
        int i,j;

        public Keypad(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
/*
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Keypad left = new Keypad(3,0);
        Keypad right = new Keypad(3,2);
        for (int number : numbers) {
            if(number == 1 || number == 4 || number == 7) {
               answer += "L";
               if(number==1) {
                   left.position(0,0);
               } else if(number==4) {
                   left.position(1,0);
               } else if(number==7) {
                   left.position(2,0);
               }
            } else if(number == 3 || number == 6 || number == 9) {
                answer += "R";
                if(number==3) {
                    right.position(0,2);
                } else if(number==6) {
                    right.position(1,2);
                } else if(number==9) {
                    right.position(2,2);
                }
            } else {
                int i = 0;
                int j = 0;
                if(number == 2) {
                    i = 0;
                    j = 1;
                } else if(number == 5) {
                    i = 1;
                    j = 1;
                } else if(number == 8) {
                    i = 2;
                    j = 1;
                } else if(number == 0) {
                    i = 3;
                    j = 1;
                }
                int disL = Math.abs(i-left.i) + Math.abs(j-left.j);
                int disR = Math.abs(i-right.i) + Math.abs(j-right.j);
                if(hand.equals("right")) {
                    if(disL>=disR) {
                        answer += "R";
                        right.position(i,j);
                    } else {
                        answer += "L";
                        left.position(i,j);
                    }
                } else {
                    if(disR>=disL) {
                        answer += "L";
                        left.position(i,j);
                    } else {
                        answer += "R";
                        right.position(i,j);
                    }
                }
            }

        }
        return answer;
    }
        static class Keypad{
        int i,j;

        public Keypad(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void position(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }
}
 */

/*다른사람풀이.
class Solution {
    //        0부터 9까지 좌표 {y,x}
    int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    //초기 위치
    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    String hand;
    public String solution(int[] numbers, String hand) {
        this.hand = (hand.equals("right")) ? "R" : "L";

        String answer = "";
        for (int num : numbers) {
            String Umji = pushNumber(num);
            answer += Umji;

            if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
            if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
        }
        return answer;
    }

    //num버튼을 누를 때 어디 손을 사용하는가
    private String pushNumber(int num) {
        if(num==1 || num==4 || num==7) return "L";
        if(num==3 || num==6 || num==9) return "R";

        // 2,5,8,0 일때 어디 손가락이 가까운가
        if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
        if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

        //같으면 손잡이
        return this.hand;
    }

    //해당 위치와 번호 위치의 거리
    private int getDist(int[] pos, int num) {
        return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
    }
}
 */