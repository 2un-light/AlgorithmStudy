import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i = 0; i < food.length; i++) {
            if(food[i] >= 2) {
                int cnt = food[i] / 2;
                for(int j = 0; j < cnt; j++) {
                    answer += i;
                }
            }else {
                continue;
            }
        }
        
        //생수 추가 전 백업
        String backup = answer;
        
        //생수 추가
        answer += "0";
        
        //남은 문자열 추가
        String reversed = new StringBuilder(backup).reverse().toString();
        answer += reversed;
        
        return answer;
    }
}