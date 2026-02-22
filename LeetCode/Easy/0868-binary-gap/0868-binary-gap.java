class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);

        int longestDist = 0;
        int prev = -1;
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                if(prev != -1) {
                    longestDist = Math.max(longestDist, i - prev);
                }
                prev = i;
            }
        }

        return longestDist;
    }
}