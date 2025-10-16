import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        
        for(int i = n + 1; i <= 1000000; i++) {
            if(cnt1(n) == cnt1(i)) {
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
    
    public int cnt1(int n) {
        int cnt = 0;
        String string = Integer.toBinaryString(n);
        for(char c : string.toCharArray()) {
            if(c == '1'){
                cnt++;
            }
        }
        
        return cnt;
    }
}