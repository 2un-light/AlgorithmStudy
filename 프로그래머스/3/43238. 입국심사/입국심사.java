import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        //times 정렬
        Arrays.sort(times);
        
        long start = 1; //시작 (최소시간)
        long end = (long)times[times.length - 1] * n; //끝(최대시간)
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            
            for(int time : times) {
                count += (mid / time);
                if(count >= n) break;
            }
            
            if(count >= n) {
                answer = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        
        
        
        
        return answer;
    }
}