import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> answer =  new ArrayList<>();

        while(n != 0) {
            int result = (int) (n % 10);
            answer.add(result);
            
            n /= 10;
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
        
    }
}