import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        
        int billW = bill[0];
        int billH = bill[1];
        
        while(true) {
            int billMin = Math.min(billW, billH);
            int billMax = Math.max(billW, billH);
            
            if(billMin <= walletMin && billMax <= walletMax) {
                break;
            }
            
            if(billW >= billH) {
                billW /= 2;
            }else {
                billH /= 2;
            }
            
            answer++;
        }
        
        return answer;
        
        
        
    }
}