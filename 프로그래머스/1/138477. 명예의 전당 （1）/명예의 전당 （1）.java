import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> fameList = new ArrayList();
        
        int index = 0;
        for(int i = 0; i < score.length; i++) {
            fameList.add(score[i]);
            Collections.sort(fameList, Collections.reverseOrder());
            if(fameList.size() < k + 1) {
                answer[index] = fameList.get(i);
                index++;
            }else {
                answer[index] = fameList.get(k - 1);
                index++;
            }
            
            
        }
        return answer;
    }
}