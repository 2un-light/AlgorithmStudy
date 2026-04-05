import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(s < n) return new int[]{-1};
        
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            int num = s / (n - i);
            answer[i] = num;
            s -= num;
        }
        
        return answer;
        
    }
}