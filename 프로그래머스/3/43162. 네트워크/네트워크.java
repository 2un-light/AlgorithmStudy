import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, computers, visited);
                answer++;
            }
        }
    
        
        return answer;
    }
    
    public void bfs(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i = 0; i < computers.length; i++) {
                if(computers[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}