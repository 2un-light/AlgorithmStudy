class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int step = 1; step <= s.length(); step++) {
            StringBuilder sb = new StringBuilder();
            //첫 덩어리
            String prev = s.substring(0, step);
            int count = 1;
        
            
            for(int j = step; j < s.length(); j+=step) {
                String current = s.substring(j, Math.min(j+step, s.length()));
                
                
                if(prev.equals(current)) {
                    count++;
                }else {
                    if(count > 1) sb.append(count);
                    sb.append(prev);
                    prev = current;
                    count = 1;
                }
                
            }
            
            //마지막 덩어리 처리
            if(count > 1) sb.append(count);
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }
        
        
        return answer;
    }
}