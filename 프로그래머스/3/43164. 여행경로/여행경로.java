import java.io.*;
import java.util.*;

class Solution {
    boolean[] visited;
    List<String> path = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        //도착지 기준 사전순 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        //방문 배열 생성
        visited = new boolean[tickets.length];
        
        //시작점
        path.add("ICN");
        
        //bfs 탐색
        bfs("ICN", tickets, 0);
        
        return answer.toArray(String[]::new);
    }
    
    //dfs 탐색 메서드
    private boolean bfs(String current, String[][] tickets, int depth) {
        if(depth == tickets.length) {
            answer = new ArrayList<>(path);
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                
                visited[i] = true;
                path.add(tickets[i][1]);
                
                
                if(bfs(tickets[i][1], tickets, depth + 1)) {
                    return true;
                }
                //백트래킹
                visited[i] = false;
                path.remove(path.size() - 1);
                
            }
        }
        
        return false;
        
    }
    

}