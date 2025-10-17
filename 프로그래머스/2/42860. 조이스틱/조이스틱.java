import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        //위아래 이동
        for(int i = 0; i < length; i++) {
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
        }
        
        //좌우 이동
        int move = length - 1;
        for(int i = 0; i < length; i++) {
            int next = i + 1;
            //다음 글자가 A인 경우 스킵
            while(next < length && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + length - next + Math.min(i, length - next));
        }
        
        
        return answer += move;
    }
}