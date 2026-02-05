import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        int num = 0;
        int idx = 0;
        
        while(answer.length() < t) {
            String s = Integer.toString(num, n).toUpperCase();
            
            for(int i = 0; i < s.length(); i++) {
                if(idx % m == p - 1) {
                    answer.append(s.charAt(i));
                    if(answer.length() == t) break;
                }
                idx++;
            }
            num++;
            
        }
        
        return answer.toString();
    }
}