import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> dictionary = new HashMap<>();
        
        //사전 초기화
        int dictIdx = 1;
        for(char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), dictIdx++);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int i = 0;
        while(i < msg.length()) {
            String w = "";
            int j = i;
            
            //사전에 있는 가장 긴 문자열 찾기
            while(j < msg.length()) {
                String next = msg.substring(i, j + 1);
                if(!dictionary.containsKey(next)) {
                    break;
                }
                w = next;
                j++;
            }
            
            answer.add(dictionary.get(w));
            
            if(i + w.length() < msg.length()) {
                String newWord = msg.substring(i, i + w.length() + 1);
                dictionary.put(newWord, dictIdx++);
            }
            
            i += w.length();
            
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}