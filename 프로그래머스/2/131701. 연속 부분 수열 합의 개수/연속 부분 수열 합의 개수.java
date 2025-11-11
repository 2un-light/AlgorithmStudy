import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> result = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++) {
            for(int j = 1; j <= elements.length; j++) {
                int sum = 0;
                for(int k = i; k < i + j ; k++) {
                    int index = 0;
                    index = k >= elements.length ? k % elements.length : k;
                    sum += elements[index];
                }
                result.add(sum);
            }

        }
        
        answer = result.size();
        
        return answer;
    }
}