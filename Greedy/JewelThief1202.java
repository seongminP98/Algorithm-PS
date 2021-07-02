import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class JewelThief1202 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] jewel = new int[N][2]; // 무게, 가격
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                jewel[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] bag = new int[K];
        for(int i=0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
//        for(int i=0; i<N; i++){
//            for(int j=0; j<2; j++){
//                System.out.print(jewel[i][j]+" ");
//            }
//            System.out.println();
//        }
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        int k=0;
        boolean check = true;
        for(int i=0; i<K; i++){
            if(check){
                for(int j=k; j<N; j++){
                    //System.out.println("가방무게"+i+" "+bag[i]);
                    if(bag[i]>=jewel[j][0]){
                        pq.add(jewel[j][1]);
                        if(j==N-1){
                            check = false;
                        }

                        //System.out.println(i+" "+j+" "+jewel[j][1]);
                    }else{
                        k=j;
                        //System.out.println(k);
                        break;
                    }
                }
            }

            if(!pq.isEmpty())
                ans += pq.poll();
        }
        System.out.println(ans);
    }
}
