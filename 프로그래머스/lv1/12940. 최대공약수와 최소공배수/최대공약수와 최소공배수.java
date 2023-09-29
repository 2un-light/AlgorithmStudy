class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {0,0};
        
        	for(int i = 1; i <= m; i++) {
        		if(n % i == 0 && m % i == 0) {
        			answer[0] = i;
        			answer[1] = i * (n/i) * (m/i);
        		}
        }
        
        return answer;
    }
}