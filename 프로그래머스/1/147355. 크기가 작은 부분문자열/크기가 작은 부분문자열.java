import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int len = p.length();
        
        for(int i = 0; i <= t.length() - len; i++) {
            String sub = t.substring(i, i + len);
            
            if(sub.compareTo(p) <= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}