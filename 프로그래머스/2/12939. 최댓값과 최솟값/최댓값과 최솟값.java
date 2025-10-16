import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String[] input = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);
            
            if(num < min) {
                min = num;
            }
            
            if(num > max) {
                max = num;
            }
                
        }
        
        String answer = "";
        answer += min;
        answer += " ";
        answer += max;
        
        
        
        return answer;
    }
}