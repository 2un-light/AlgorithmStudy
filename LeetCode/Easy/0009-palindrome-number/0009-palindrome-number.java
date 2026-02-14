class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String number = String.valueOf(x);
        String reversed = new StringBuilder(number).reverse().toString();

        if(number.equals(reversed)) {
            return true;
        }


        return false;
    }
}