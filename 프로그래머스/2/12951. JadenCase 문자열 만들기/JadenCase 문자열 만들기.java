class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean isFirst = true;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(isFirst) {
                // 첫 글자면
                if(Character.isLetter(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
                isFirst = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
            
            // 공백이면 다음 문자는 다시 첫 글자
            if(c == ' ') {
                isFirst = true;
            }
        }
        
        return sb.toString();
    }
}