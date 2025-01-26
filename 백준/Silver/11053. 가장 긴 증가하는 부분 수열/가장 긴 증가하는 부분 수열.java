import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        //수열 입력
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[n];
        //dp 초기화
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for(int i = 0; i < n; i++){
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);

    }
}
