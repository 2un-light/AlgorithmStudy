import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> tangerineMap = new HashMap<>(); //<귤 사이즈, 해당 사이즈 귤의 갯수>
        for(int size : tangerine) {
            tangerineMap.put(size, tangerineMap.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(tangerineMap.values());
        Collections.sort(counts, Collections.reverseOrder());
        
        int sum = 0;
        int kinds = 0;
        
        for(int count : counts) {
            sum += count;
            kinds++;
            if(sum >= k) break;
        }
        
        return kinds;
        
    }
}