class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                
                if(j == 0) {
                    //맨 왼쪽
                    triangle[i][j] += triangle[i - 1][j];
                }else if(j == triangle[i].length - 1) {
                    //맨 오른쪽
                    triangle[i][j] += triangle[i - 1][j - 1];
                }else {
                    triangle[i][j] += Math.max(
                        triangle[i - 1][j - 1],
                        triangle[i - 1][j]
                    );
                }
            }
        }
        
        int answer = 0;
        for(int num : triangle[n - 1]) {
            answer = Math.max(answer, num);
        }
        
        return answer;
        
    }
}