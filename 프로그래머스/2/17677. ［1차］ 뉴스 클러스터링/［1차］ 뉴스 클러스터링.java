import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        
        //대문자 변환
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> mapA = new HashMap();
        Map<String, Integer> mapB = new HashMap();
        
        //각각의 집합에 정제된 원소 넣기
        for(int i = 0; i < str1.length() - 1; i++) {
            String word = str1.substring(i, i + 2);
            word = word.replaceAll("[^A-Z]", "");
            if(word.length() == 2) {
                mapA.put(word, mapA.getOrDefault(word, 0) + 1);
            }
        }
        
         for(int i = 0; i < str2.length() - 1; i++) {
            String word = str2.substring(i, i + 2);
            word = word.replaceAll("[^A-Z]", "");
            if(word.length() == 2) {
                mapB.put(word, mapB.getOrDefault(word, 0) + 1);
            }
        }
        
        //비교
        int union = 0;
        int intersection = 0;
        
        Set<String> keys = new HashSet();
        keys.addAll(mapA.keySet());
        keys.addAll(mapB.keySet());
        
        for(String key : keys) {
            int countA = mapA.getOrDefault(key, 0);
            int countB = mapB.getOrDefault(key, 0);
            
            intersection += Math.min(countA, countB);
            union += Math.max(countA, countB);
        }
        
        
        if(union == 0) return 65536;
        
        return (int)((double) intersection / union * 65536);

    }
}