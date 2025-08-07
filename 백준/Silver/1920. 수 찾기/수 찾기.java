import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(binarySearch(A, key)) {
                sb.append("1").append("\n");
            }else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == key) return true;
            if(arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

}
