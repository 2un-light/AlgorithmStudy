class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        
        // dp[i][j][k]: 0을 i개, 1을 j개 사용, 마지막 원소가 k인 stable array 수
        long[][][] dp = new long[zero + 1][one + 1][2];
        
        // 초기값
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // 마지막이 0인 경우
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]
                              - (i - limit >= 1 ? dp[i-limit-1][j][1] : 0)
                              + MOD) % MOD;
                
                // 마지막이 1인 경우
                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]
                              - (j - limit >= 1 ? dp[i][j-limit-1][0] : 0)
                              + MOD) % MOD;
            }
        }
        
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}