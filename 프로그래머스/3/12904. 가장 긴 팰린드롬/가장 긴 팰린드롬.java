import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1;
        
        for(int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, expand(s, i, i));
            answer = Math.max(answer, expand(s, i, i + 1));
        }
        
        return answer;
    }
    
    public int expand(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        
        return end - start - 1;
    }
}