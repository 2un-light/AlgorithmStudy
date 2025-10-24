import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        //금액이 적은 부서부터 지원
        Arrays.sort(d);
        
        for(int i = 0; i < d.length; i++) {
            int num = d[i];
            budget -= num;
            if(budget >= 0) {
                answer++;
            }else {
                break;
            }
        }
    
        
        return answer;
    }
}