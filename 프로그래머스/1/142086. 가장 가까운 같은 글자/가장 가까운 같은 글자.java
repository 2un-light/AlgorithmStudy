import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> wordMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!wordMap.containsKey(c)) {
                wordMap.put(c, i);
                answer[i] = -1;
            }else {
                
                Integer index = wordMap.get(c);
                answer[i] = i - (int)index;
                
                //map 갱신
                wordMap.put(c, i);
            }
        }
        
        
        return answer;
    }
}