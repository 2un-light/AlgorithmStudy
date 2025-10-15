import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        //n(행)과 m(열)
        int n = maps.length;
        int m = maps[0].length;
        
        //방문 3차원 배열 생성
        boolean[][] visited = new boolean[n][m];
        
        //상하좌우 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0, 0, 1}); //시작위치와 거리 1
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int cx = cur[0]; //현재 x위치
            int cy = cur[1]; //현재 Y 위치
            int dist = cur[2];
            
            if(cx == n - 1 && cy == m - 1) {
                return dist;
            }
            
            //상하 좌우 이동
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m &&
                  maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
                
            }  
   
        }

        
        return -1;
    }
}