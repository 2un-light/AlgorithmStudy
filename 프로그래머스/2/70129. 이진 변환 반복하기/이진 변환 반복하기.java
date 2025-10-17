class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeroCount = 0;
        
        while(!s.equals("1")) {
            int prevLength = s.length();
            
            //0제거
            s = s.replace("0","");
            zeroCount += prevLength - s.length();
            
            //0제거 후 길이 이진변환
            int currentLength = s.length();
            s = Integer.toBinaryString(currentLength);
            
            count++;
            
        }
        
        return new int[]{count, zeroCount};
        
    }
}