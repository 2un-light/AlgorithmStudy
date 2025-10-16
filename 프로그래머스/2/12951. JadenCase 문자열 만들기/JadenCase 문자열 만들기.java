import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true; //단어의 첫글자 여부 판단
        
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                sb.append(c);
                isFirst = true;
            }else {
                if(isFirst) {
                    sb.append(Character.toUpperCase(c));
                    isFirst = false;
                }else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        
        return sb.toString();
        
    }
}