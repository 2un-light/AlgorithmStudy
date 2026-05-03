import java.util.*;

class Solution {
    
    //Node 클래스
    static class Node {
        int x, y, dir, cost;
        
        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int n = board.length;
        
        //cost[x][y][dir]
        //dir : 상(0), 하(1), 좌(2), 우(3)
        int[][][] cost = new int[n][n][4];
        
        //초기값을 큰 값으로 세팅
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        //시작 : 오른쪽(3), 아래(1)
        queue.offer(new Node(0, 0, 3, 0));
        queue.offer(new Node(0, 0, 1, 0));
        
        cost[0][0][1] = 0;
        cost[0][0][3] = 0;
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                //범위 체크
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                //벽
                if(board[nx][ny] == 1) continue;
                
                int newCost;
                
                //같은 방향
                if(cur.dir == i) {
                    newCost = cur.cost + 100;
                }else {
                    newCost = cur.cost + 600;
                }
                
                //더 싸게 오는 경우 갱신
                if(cost[nx][ny][i] > newCost) {
                    cost[nx][ny][i] = newCost;
                    queue.offer(new Node(nx, ny, i, newCost));
                }
            }
        }
        
        //도착 지점 최솟값
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[n-1][n-1][i]);
        }
        
        return answer;
        
    }
}