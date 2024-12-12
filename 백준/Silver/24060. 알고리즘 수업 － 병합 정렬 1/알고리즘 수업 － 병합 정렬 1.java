import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1, k);
        System.out.println(result);


    }

    public static void mergeSort(int[] arr, int left, int right, int k){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, k);
            mergeSort(arr, mid + 1, right, k);
            merge(arr, left, mid, right, k);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int k){
        int[] temp = new int[right - left + 1]; //병합된 결과 저장할 임시 배열 생성
        int i = left;
        int j = mid + 1;
        int t = 0;
        while((i <= mid) && (j <= right)){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        while(i <= mid){ //왼쪽이 남은 경우
            temp[t++] = arr[i++];
        }
        while(j <= right){ //오른쪽이 남은 경우
            temp[t++] = arr[j++];
        }

        for(int p = 0; p < temp.length; p++){
            arr[left + p] = temp[p];
            cnt++;
            if(cnt == k){
                result = arr[left + p];
                return;
            }
        }
        
    }
}
