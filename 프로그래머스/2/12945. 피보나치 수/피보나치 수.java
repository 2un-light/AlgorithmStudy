class Solution {
    int[] memo = new int[100001];
    
    public int solution(int n) {
        return fibonacci(n);
    }
    
    public int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(memo[n] != 0) return memo[n];
        
        memo[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
        return memo[n];
    
        
    }
    
}