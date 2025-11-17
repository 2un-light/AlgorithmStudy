import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> part1 = new HashSet<>();
        Map<Integer, Integer> part2 = new HashMap<>();
        
        //map에 전체 토핑과 갯수 저장
        for(int t : topping) {
            part2.put(t, part2.getOrDefault(t, 0) + 1);
        }
        
        int answer = 0;
        
        for(int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            
            part1.add(t);
            
            part2.put(t, part2.get(t) - 1);
            if(part2.get(t) == 0) {
                part2.remove(t);
            }
            
            if(part1.size() == part2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}