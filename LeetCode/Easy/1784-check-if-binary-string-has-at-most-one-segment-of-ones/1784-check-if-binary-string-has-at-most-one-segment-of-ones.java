class Solution {
    public boolean checkOnesSegment(String s) {
        
        int part = 0; //1부터 시작, 1의 인덱스
        for(int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current == '1') {
                if(part + 1 == i) {
                    part = i;
                }else {
                    return false;
                }
            }
        }

        return true;
        
    }   
}