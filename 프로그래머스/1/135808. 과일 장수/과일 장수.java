import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Integer[] arr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        
        for(int i =  m - 1; i < arr.length; i += m) {
            answer += arr[i] * m;
        }
        
        
        return answer;
    }
}