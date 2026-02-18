class Solution {
    public boolean hasAlternatingBits(int n) {
        String bit = Integer.toBinaryString(n);

        int prev = bit.charAt(0) - '0';
        for(int i = 1; i < bit.length(); i++) {
           int current = bit.charAt(i) - '0';
           if(prev == current) return false;
           prev = current;
        }

        return true;
    }
}