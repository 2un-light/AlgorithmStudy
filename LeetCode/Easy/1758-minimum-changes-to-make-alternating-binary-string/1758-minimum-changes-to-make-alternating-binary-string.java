class Solution {
    public int minOperations(String s) {

        int case1 = 0; //010101..
        int case2 = 0; //101010..

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(i % 2 == 0) {
                if(c != '0') case1++;
                if(c != '1') case2++;
            }else {
                if(c != '1') case1++;
                if(c != '0') case2++;
            }
        }

        return Math.min(case1, case2);

    }
}