import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        //역순 정렬
        Arrays.sort(score);
        
        for(int i = 0; i < score.length / 2; i++) {
            int temp = score[i];
            score[i] = score[score.length - 1 - i];
            score[score.length - 1 - i] = temp;
        }
        
        int box = score.length / m;
        
        int index = m - 1;
        while(box > 0) {
            int price = score[index] * m;
            answer += price;
            index += m;
            box--;
        }
        
        return answer;
    }
}