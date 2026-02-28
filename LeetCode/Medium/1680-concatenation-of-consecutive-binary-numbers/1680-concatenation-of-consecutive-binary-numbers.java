class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int modulo = 1000000007;

        for(int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            for(char c : binary.toCharArray()) {
                result = (result * 2 + (c - '0')) % modulo;
            }
        }

        return (int) result;
    }
}