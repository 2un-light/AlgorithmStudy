import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1; // 현재 기회 인덱스
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            // 1) 숫자 처리
            if (Character.isDigit(c)) {
                int num = c - '0';
                // “10” 처리: 다음이 ‘0’이면 10
                if (i+1 < dartResult.length() && dartResult.charAt(i+1) == '0') {
                    num = 10;
                    i++;
                }
                idx++;
                scores[idx] = num;
            }
            // 2) 영역 처리
            else if (c == 'S') {
                scores[idx] = (int) Math.pow(scores[idx], 1);
            }
            else if (c == 'D') {
                scores[idx] = (int) Math.pow(scores[idx], 2);
            }
            else if (c == 'T') {
                scores[idx] = (int) Math.pow(scores[idx], 3);
            }
            // 3) 옵션 처리
            else if (c == '*') {
                scores[idx] *= 2;
                if (idx > 0) {
                    scores[idx-1] *= 2;
                }
            }
            else if (c == '#') {
                scores[idx] *= -1;
            }
        }
        
        int answer = scores[0] + scores[1] + scores[2];
        return answer;
    }
}