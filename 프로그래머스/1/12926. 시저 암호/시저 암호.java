import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(c == ' '){
                sb.append(" ");
            }else if(Character.isUpperCase(c)) {
                char shifted = (char) ((c - 'A' + n) % 26 + 'A');
                sb.append(shifted);
            }else if(Character.isLowerCase(c)) {
                char shifted = (char) ((c - 'a' + n) % 26 + 'a');
                sb.append(shifted);
            }
        }
        
        return sb.toString();
    }
}