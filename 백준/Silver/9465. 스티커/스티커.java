import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int col = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][col];

            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < col; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] dp = new int[3];
            dp[0] = 0;
            dp[1] = sticker[0][0];
            dp[2] = sticker[1][0];

            for(int i = 1; i < col; i++) {
                int[] next = new int[3];
                next[0] = Math.max(dp[0], Math.max(dp[1], dp[2]));
                next[1] = Math.max(dp[0], dp[2]) + sticker[0][i];
                next[2] = Math.max(dp[0], dp[1]) + sticker[1][i];
                dp = next;
            }

            sb.append(Math.max(dp[0], Math.max(dp[1], dp[2]))).append('\n');

        }

        System.out.println(sb);

    }
}
