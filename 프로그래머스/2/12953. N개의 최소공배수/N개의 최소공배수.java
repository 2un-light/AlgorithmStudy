class Solution {
    public int solution(int[] arr) {
        
        int result = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        
        return result;
    }
    
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}