import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap();
        
        for(int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        for(String name : callings) {
            int idx = rankMap.get(name);
            if(idx == 0) continue;
            
            String front = players[idx - 1];
            players[idx - 1] = players[idx];
            players[idx] = front;
            
            rankMap.put(name, idx - 1);
            rankMap.put(front, idx);
        }
        
        return players;
    }
}