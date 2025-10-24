import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        long numP = Long.parseLong(p);
        
        for(int i = 0; i <= t.length() - pLen; i++) {
            String sub = t.substring(i, i + pLen);
            long numSub = Long.parseLong(sub);
            
            if(numSub <= numP) {
                answer++;
            }
        }
        
        
        return answer;
    }
}