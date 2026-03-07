class Solution {
    public int minFlips(String s) {
        int n = s.length();

        String ss = s + s;
        
        int diff1 = 0; //0으로 시작할 경우
        int diff2 = 0; //1로 시작할 경우

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < ss.length(); i++) {
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if(ss.charAt(i) != expected1) diff1++;
            if(ss.charAt(i) != expected2) diff2++;

            if(i >= n) {
                char prev = ss.charAt(i - n);
                
                char prevExpected1 = ((i - n) % 2 == 0) ? '0' : '1';
                char prevExpected2 = ((i - n) % 2 == 0) ? '1' : '0';

                if(prev != prevExpected1) diff1--;
                if(prev != prevExpected2) diff2--;
            }

            if(i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;


    }
}