import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> keyMap = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            for (int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                keyMap.put(c, Math.min(keyMap.getOrDefault(c, j + 1), j + 1));
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int total = 0;
            boolean possible = true;
            
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                if (!keyMap.containsKey(c)) {
                    possible = false;
                    break;
                }
                total += keyMap.get(c);
            }
            
            answer[i] = possible ? total : -1;
        }
        
        return answer;
    }
}
