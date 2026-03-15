import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0;
        for(int work : works) {
            pq.add(work);
            sum += work;
        }
        
        //모든 일을 끝낼 수 있는 경우
        if(sum <= n) return 0;
        
        //n시간동안 가장 큰 값을 줄이기
        for(int i = 0; i < n; i++) {
            int max = pq.poll();
            pq.add(max - 1);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }
        
        return answer;

    }
}