class Solution {
    public int countPrimeSetBits(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            int count = Integer.bitCount(i);
            if(isPrime(count)) answer++;
        }

        return answer;
    }

    public boolean isPrime(int num) {
        if(num < 2) return false;

        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}