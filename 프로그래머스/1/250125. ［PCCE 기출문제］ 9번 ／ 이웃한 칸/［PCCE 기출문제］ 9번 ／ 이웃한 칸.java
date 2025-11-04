import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int n = board.length;
        int m = board[0].length;
        
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + h;
            int ny = dy[i] + w;
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(board[nx][ny].equals(color)) {
                    answer++;
                }
            }
            
        }
        
        
        return answer;
    }
}