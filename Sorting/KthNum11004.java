import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KthNum11004 {
    static int K, N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quicksort(arr,0,N-1);
        System.out.print(arr[K-1]);
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }
    static int partition(int[] arr, int left, int right){
        int mid = (left+right)/2;

        swap(arr,left,mid); //mid와 left swap

        int pivot = arr[left];
        int i=left;
        int j = right;

        while(i<j){
            while(pivot<arr[j]){ //j는 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다.
                j--;
            }
            while(i<j && pivot>=arr[i]){ //i는 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다.
                i++;
            }
            swap(arr,i,j); //찾은 i와 j를 swap
        }
        arr[left]=arr[i]; //i와 j가 만난경우 피봇과 교환.
        arr[i]=pivot;
        return i;
    }
    static void quicksort(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int pi = partition(arr,left,right);
        
        if(pi+1==K)
            return;
        else if(pi+1<K)
            quicksort(arr,pi+1,right);
        else
            quicksort(arr,left,pi-1);
    }
}
