import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        
        //진출값을 기준으로 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        for(int[] route : routes) {
            if(route[0] > camera) {
                answer++;
                camera = route[1];
            }
        }
        
        
        return answer;
    }
}