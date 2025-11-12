class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr1[0].length;
        int k = arr2[0].length;
        
        int[][] answer = new int[n][k];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                for(int x = 0; x < m; x++) {
                    answer[i][j] += arr1[i][x] * arr2[x][j];
                }
            }
        }
        
        return answer;
    }
}