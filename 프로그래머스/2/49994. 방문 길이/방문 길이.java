import java.io.*;
import java.util.*;

class Solution {
    Set<String> visited = new HashSet();
    
    public int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;
        
        for(char c : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            
            switch(c) {
                case 'U': ny++; break;
                case 'D': ny--; break;
                case 'R': nx++; break;
                case 'L': nx--; break;
            }
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5)
                continue;
            
            visited.add(makeEdge(x, y, nx, ny));
            x = nx;
            y = ny;
        }
        
        answer = visited.size();
        
        return answer;
    }
    
    public String makeEdge(int x1, int y1, int x2, int y2) {
        String a = x1 + "," + y1;
        String b = x2 + "," + y2;
        if(a.compareTo(b) < 0) return a + "-" + b;
        else return b + "-" + a;
    }
}