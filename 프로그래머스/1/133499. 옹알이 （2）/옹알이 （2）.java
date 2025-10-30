class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for(String b : babbling) {
            String prev = "";
            boolean canSpeak = true;
            
            while(!b.isEmpty()) {
                boolean matched = false;
                
                for(String w : words) {
                    if(b.startsWith(w)) {
                        if(w.equals(prev)) {
                            canSpeak = false;
                            break;
                        }
                        
                        b = b.substring(w.length());
                        prev = w;
                        matched = true;
                        break;
                    }
                }
                
                if(!matched) {
                    canSpeak = false;
                    break;
                }
            }
            
            if(canSpeak) count++;
        }
        
        return count;
        
    }
}