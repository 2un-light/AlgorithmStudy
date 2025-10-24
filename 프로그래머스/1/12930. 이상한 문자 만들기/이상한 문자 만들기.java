import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                answer += " ";
                index = 0;
            }else {
                if(index % 2 == 0) {
                    answer += String.valueOf(c).toUpperCase();
                }else {
                    answer += String.valueOf(c).toLowerCase();
                }
                index++;
            }
    
        }
        
      
        
        
        return answer;
    }
}