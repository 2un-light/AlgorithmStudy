import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[41][2];

        //fibonacci(0)
        dp[0][0] = 1;
        dp[0][1] = 0;

        //fibonacci(1)
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        while(T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][0] + " " + dp[num][1]).append("\n");
        }

        System.out.println(sb);

    }

}
