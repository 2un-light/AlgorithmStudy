import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left) + 1;
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++) {
            long k = left + i; 
            long row = k / n;
            long col = k % n;
            answer[i] = (int)(Math.max(row, col) + 1);
        }
        
        return answer;
    }
}