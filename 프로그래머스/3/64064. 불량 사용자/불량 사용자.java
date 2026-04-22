import java.io.*;
import java.util.*;

class Solution {
    static Set<Set<String>> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, 0, new HashSet<>());
        return result.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, int depth, Set<String> current) {
        if(depth == banned_id.length) {
            result.add(new HashSet<>(current));
            return;
        }
        
        String banned = banned_id[depth];
        
        for(String user : user_id) {
            if(current.contains(user)) continue;
            
            if(isMatch(user, banned)) {
                current.add(user);
                dfs(user_id, banned_id, depth + 1, current);
                current.remove(user);
            }
        }
    }
    
    private boolean isMatch(String user, String banned) {
        if(user.length() != banned.length()) {
            return false;
        }
        
        for(int i = 0; i < user.length(); i++) {
            if(banned.charAt(i) == '*') continue;
            if(user.charAt(i) != banned.charAt(i)) return false;
        }
        
        return true;
    }
}