import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Deque10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if(deque.size()==0)
                        System.out.println(-1);
                    else{
                        System.out.println(deque.removeFirst());
                        deque.remove(0);
                    }
                    break;

                case "pop_back":
                    if(deque.size()==0)
                        System.out.println(-1);
                    else{
                        System.out.println(deque.removeLast());
                        deque.remove(0);
                    }
                    break;

                case "size":
                    System.out.println(deque.size());
                    break;

                case "empty" :
                    if(deque.size()==0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;

                case "front":
                    if(deque.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(deque.getFirst());
                    break;
                case "back":
                    if(deque.size()==0)
                        System.out.println(-1);
                    else
                        System.out.println(deque.getLast());
                    break;

                default:
                    break;
            }

        }
    }
}
