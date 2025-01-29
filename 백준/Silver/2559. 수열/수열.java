import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //초기 K개의 합
        int sum = 0;
        for(int i = 0; i < K; i++){
            sum += arr[i];
        }

        int maxSum = sum;
        for(int i = K; i < N; i++){
            sum = sum - arr[i - K] + arr[i];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
