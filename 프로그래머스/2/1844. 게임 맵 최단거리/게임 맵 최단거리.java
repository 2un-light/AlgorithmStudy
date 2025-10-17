import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        //해당 칸 방문 여부
        boolean[][] visited = new boolean[n][m];
        
        //상하좌우 이동시 좌표 변화 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); //x좌표, y좌표, 이동 거리
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int distance = current[2];
            
            if(cx == n - 1 && cy == m - 1) {
                return distance;
            }
     
            //상하좌우 이동
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                //갈 수 있는 길이라면
                if(nx >= 0 && nx < n && ny >= 0 && ny < m
                  && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true; //방문처리
                    queue.add(new int[]{nx, ny, distance + 1}); //queue에 다음 위치 추가
                }
            }
            
            
            
        }     
        
        return -1;
    }
}