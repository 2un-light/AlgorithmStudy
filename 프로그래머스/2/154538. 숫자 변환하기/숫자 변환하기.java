import java.io.*;
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        queue.offer(x);
        visited[x] = true;
        
        int count = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                
                if(current == y) {
                    return count;
                }
                
                int[] next = {current + n, current * 2, current * 3};
                
                for(int num : next) {
                    if(num <= y && !visited[num]) {
                        visited[num] = true;
                        queue.offer(num);
                    }
                }
            }
            
            count++;
            
        }
        
        
        
        
        return -1;
    }
}