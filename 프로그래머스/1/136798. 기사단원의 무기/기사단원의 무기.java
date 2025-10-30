import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int cnt = getDivisorCnt(i);
            
            if(cnt > limit) {
                answer += power;
            }else {
                answer += cnt;
            }
        }
        
        
        return answer;
    }
    
    private int getDivisorCnt(int num) {
        int cnt = 0;
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                cnt++;
                if(i * i != num) cnt++;
            }
        }
        
        return cnt;
    }
}