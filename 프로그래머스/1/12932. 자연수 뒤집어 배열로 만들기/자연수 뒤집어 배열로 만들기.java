import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};

        //처음 나눌 수 정하기
        int length = String.valueOf(n).length();
        answer = new int[length];
        
        int div = 1;
        for(int i = 0; i < length - 1; i++) {
            div *= 10;
        }
        
        int idx = 0;
        while(true) {
            int num = (int) (n / div);
            answer[idx] = num;
            idx++;
            
                   
            if(idx > length - 1) {
                break;
            }
            
            n = n % div;
            div /= 10;

        }
        
        //뒤집기
        int[] answer2 = new int[length];
        for(int i = 0; i < length; i++) {
            answer2[i] = answer[length - 1 - i];
        }
        
        return answer2;
    }
}