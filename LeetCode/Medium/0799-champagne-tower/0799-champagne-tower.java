class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[0][0] = poured;

        for(int r = 0; r <= query_row; r++) {
            for(int c = 0; c <= r; c++) {

                if(dp[r][c] > 1) {
                    double overflow = (dp[r][c] - 1.0) / 2.0;
                    dp[r + 1][c] += overflow;
                    dp[r + 1][c + 1] += overflow;
                }

                
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}