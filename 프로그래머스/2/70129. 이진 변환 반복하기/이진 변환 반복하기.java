class Solution {
    public int[] solution(String s) {
        int count = 0;
        int removed = 0;
        
        while(!s.equals("1")) {
            int originalLength = s.length();
            s = s.replace("0", ""); //0 제거
            int newLength = s.length();
            
            removed += (originalLength - newLength);
            
            s = Integer.toBinaryString(newLength);
            
            count++;
        }
        
        return new int[]{count, removed};
            
        
    }
}