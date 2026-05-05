import java.util.*;

class Solution {
    
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> profit = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        // parent 설정
        for(int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);
        }
        
        // 판매 처리
        for(int i = 0; i < seller.length; i++) {
            distribute(seller[i], amount[i] * 100);
        }
        
        // 결과 배열
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
    
    void distribute(String person, int money) {
        if(person.equals("-") || money == 0) return;
        
        int passUp = money / 10;
        int keep = money - passUp;
        
        profit.put(person, profit.get(person) + keep);
        
        distribute(parent.get(person), passUp);
    }
}