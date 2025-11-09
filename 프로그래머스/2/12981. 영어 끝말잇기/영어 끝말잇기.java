import java.util.*;

class Solution {
    Set<String> wordSet = new HashSet<>();
    public int[] solution(int n, String[] words) {
        int[] result = new int[2];
        
        String prev = words[0];
        wordSet.add(prev);
        
        for(int i = 1; i < words.length; i++) {            
            String now = words[i];
            int personNum = i % n + 1;
            int turn = i / n + 1;
            
            if(isPossible(prev, now)) {
                wordSet.add(now);
                prev = now;
            }else {
                result[0] = personNum;
                result[1] = turn;
                break;
            }

        }

        return result;
    }
    
    public boolean isPossible(String prev, String now) {
        if((prev.charAt(prev.length() - 1) == now.charAt(0))
             && !wordSet.contains(now)) {
            return true;
        }
        
        return false;
    }
}