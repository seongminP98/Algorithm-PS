import java.util.ArrayList;

public class MaximizeFormulas {
    static char[] operation = new char[]{'+','-','*'};
    public static void main(String[] args) {
        String expression = "50*6-3*2";

        String[] splitNum = expression.replaceAll("[-+*]", " ").trim().split(" ");
        ArrayList<Long> numbers = new ArrayList<>();
        for (String s : splitNum) {
            numbers.add(Long.parseLong(s));
        }

        String operations = expression.replaceAll("[0-9]", "");
        ArrayList<Character> op = new ArrayList<>();

        for (int i=0; i<operations.length(); i++) {
            op.add(operations.charAt(i));
        }

        long max = 0;

        max = Math.max(max, calculation(numbers, op, 0, 1, 2));
        max = Math.max(max, calculation(numbers, op, 0, 2, 1));
        max = Math.max(max, calculation(numbers, op, 1, 0, 2));
        max = Math.max(max, calculation(numbers, op, 1, 2, 0));
        max = Math.max(max, calculation(numbers, op, 2, 0, 1));
        max = Math.max(max, calculation(numbers, op, 2, 1, 0));
        System.out.println("max = " + max);


    }
    static long calculation(ArrayList<Long> nums, ArrayList<Character> operations, int first, int second, int third) {
        ArrayList<Long> numbers = (ArrayList<Long>) nums.clone();
        ArrayList<Character> op = (ArrayList<Character>) operations.clone();
        for(int i=0; i<3; i++) {
            for(int j=0; j<op.size(); j++) {
                if(i==0 && op.get(j) == operation[first]) {
                    long temp = 0;
                    if(operation[first] == '+') {
                        temp = numbers.get(j) + numbers.get(j+1);
                    } else if(operation[first] == '-') {
                        temp = numbers.get(j) - numbers.get(j+1);
                    }else if(operation[first] == '*') {
                        temp = numbers.get(j) * numbers.get(j+1);
                    }
                    numbers.remove(j);
                    numbers.remove(j);
                    numbers.add(j,temp);
                    op.remove(j);
                    j--;
                } else if(i==1 && op.get(j) == operation[second]) {
                    long temp = 0;
                    if(operation[second] == '+') {
                        temp = numbers.get(j) + numbers.get(j+1);
                    } else if(operation[second] == '-') {
                        temp = numbers.get(j) - numbers.get(j+1);
                    }else if(operation[second] == '*') {
                        temp = numbers.get(j) * numbers.get(j+1);
                    }
                    numbers.remove(j);
                    numbers.remove(j);
                    numbers.add(j,temp);
                    op.remove(j);
                    j--;
                }else if(i==2 && op.get(j) == operation[third]) {
                    long temp = 0;
                    if(operation[third] == '+') {
                        temp = numbers.get(j) + numbers.get(j+1);
                    } else if(operation[third] == '-') {
                        temp = numbers.get(j) - numbers.get(j+1);
                    }else if(operation[third] == '*') {
                        temp = numbers.get(j) * numbers.get(j+1);
                    }
                    numbers.remove(j);
                    numbers.remove(j);
                    numbers.add(j,temp);
                    op.remove(j);
                    j--;
                }
            }
        }
        return Math.abs(numbers.get(0));
    }
}
/**
 * 경우의 수가 6개 뿐이라 permutation 메소드를 만들지 않고, 그냥 6가지 경우를 다 작성함.
 */
/*
import java.util.ArrayList;

class Solution {
    static char[] operation = new char[]{'+','-','*'};
    public long solution(String expression) {
        String[] splitNum = expression.replaceAll("[-+*]", " ").trim().split(" ");
        ArrayList<Long> numbers = new ArrayList<>();
        for (String s : splitNum) {
            numbers.add(Long.parseLong(s));
        }

        String operations = expression.replaceAll("[0-9]", "");
        ArrayList<Character> op = new ArrayList<>();

        for (int i=0; i<operations.length(); i++) {
            op.add(operations.charAt(i));
        }

        long answer = 0;

        answer = Math.max(answer, calculation(numbers, op, 0, 1, 2));
        answer = Math.max(answer, calculation(numbers, op, 0, 2, 1));
        answer = Math.max(answer, calculation(numbers, op, 1, 0, 2));
        answer = Math.max(answer, calculation(numbers, op, 1, 2, 0));
        answer = Math.max(answer, calculation(numbers, op, 2, 0, 1));
        answer = Math.max(answer, calculation(numbers, op, 2, 1, 0));

        return answer;
    }
    static long calculation(ArrayList<Long> nums, ArrayList<Character> operations, int first, int second, int third) {
        ArrayList<Long> numbers = (ArrayList<Long>) nums.clone();
        ArrayList<Character> op = (ArrayList<Character>) operations.clone();
        for(int i=0; i<3; i++) {
            for(int j=0; j<op.size(); j++) {
                if(i==0 && op.get(j) == operation[first]) {
                    long temp = 0;
                    if(operation[first] == '+') {
                        temp = numbers.get(j) + numbers.get(j+1);
                    } else if(operation[first] == '-') {
                        temp = numbers.get(j) - numbers.get(j+1);
                    }else if(operation[first] == '*') {
                        temp = numbers.get(j) * numbers.get(j+1);
                    }
                    numbers.remove(j);
                    numbers.remove(j);
                    numbers.add(j,temp);
                    op.remove(j);
                    j--;
                } else if(i==1 && op.get(j) == operation[second]) {
                    long temp = 0;
                    if(operation[second] == '+') {
                        temp = numbers.get(j) + numbers.get(j+1);
                    } else if(operation[second] == '-') {
                        temp = numbers.get(j) - numbers.get(j+1);
                    }else if(operation[second] == '*') {
                        temp = numbers.get(j) * numbers.get(j+1);
                    }
                    numbers.remove(j);
                    numbers.remove(j);
                    numbers.add(j,temp);
                    op.remove(j);
                    j--;
                }else if(i==2 && op.get(j) == operation[third]) {
                    long temp = 0;
                    if(operation[third] == '+') {
                        temp = numbers.get(j) + numbers.get(j+1);
                    } else if(operation[third] == '-') {
                        temp = numbers.get(j) - numbers.get(j+1);
                    }else if(operation[third] == '*') {
                        temp = numbers.get(j) * numbers.get(j+1);
                    }
                    numbers.remove(j);
                    numbers.remove(j);
                    numbers.add(j,temp);
                    op.remove(j);
                    j--;
                }
            }
        }

        return Math.abs(numbers.get(0));
    }
}
 */