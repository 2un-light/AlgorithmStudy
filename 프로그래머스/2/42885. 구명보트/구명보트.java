import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        int answer = 0;
        
        while(left <= right) {
            
            //같이 탈 수 있으면
            if(people[left] + people[right] <= limit) {
                left++;
            }
            
            //무거운 사람은 항상 태우기
            right--;
            
            answer++;
        }
        
        return answer;
        
    }
}