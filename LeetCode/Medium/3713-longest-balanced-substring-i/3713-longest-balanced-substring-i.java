class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for(int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for(int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                if(isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public boolean isBalanced(int[] freq) {
        int count = 0;

        for(int f : freq) {
            if(f > 0) {
                if(count == 0) {
                    count = f;
                }else if(count != f) {
                    return false;
                }
            }
        }

        return true;
    }
}