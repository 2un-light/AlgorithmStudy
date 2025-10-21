class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    public void dfs(int fatigue, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            int minFatigue = dungeons[i][0];
            int consumedFatigue = dungeons[i][1];
            
            if(visited[i] || fatigue < minFatigue) continue;
            
            visited[i] = true;
            dfs(fatigue - consumedFatigue, dungeons, count + 1);
            visited[i] = false;
            
        }
        
    }
    
}