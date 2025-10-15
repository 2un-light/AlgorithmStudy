import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;
            
             for(int rock : rocks) {
                 if(rock - prev < mid) {
                     cnt++;
                 }else {
                     prev = rock;
                 }
             }
            
            if(distance - prev < mid) cnt++;
            
            if(cnt <= n) {
                answer = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(25, new int[]{2, 14, 11, 21, 17}, 4));
    }
}