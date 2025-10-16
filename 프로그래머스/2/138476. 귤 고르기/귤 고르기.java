import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList(map.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        int sum = 0;
        int kind = 0;
        
        for(int count : counts) {
            sum += count;
            kind++;
            if(sum >= k) break;
        }
        
        return kind;
    
        
    }
}