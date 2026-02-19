class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0; //이전 그룹 길이
        int curr = 1; //현재 그룹 길이
        int count = 0;

        for(int i = 1; i < s.length(); i++) {

            if(s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            }else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        count += Math.min(prev, curr);

        return count;

    }
}