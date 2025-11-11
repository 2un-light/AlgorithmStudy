import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> window = new HashMap<>();
            
            for(int j = i; j < i + 10; j++) {
                window.put(discount[j], window.getOrDefault(discount[j], 0) + 1);
            }
            
            if(isSame(wantMap, window)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isSame(Map<String, Integer> a, Map<String, Integer> b) {
        for(String key : a.keySet()) {
            if(!b.containsKey(key) || !b.get(key).equals(a.get(key))) {
                return false;
            }
        }
        
        return true;
    }
}