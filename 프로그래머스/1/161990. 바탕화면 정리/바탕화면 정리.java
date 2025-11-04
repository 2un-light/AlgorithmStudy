import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        
        //폴더 위치 저장하기
        for(int i = 0; i < wallpaper.length; i++) {
            String s = wallpaper[i];
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '#') {
                    if(i < minX) {
                        minX = i;
                    }else if(i > maxX) {
                        maxX = i;
                    }
                    
                    if(j < minY) {
                        minY = j;
                    }else if(j > maxY) {
                        maxY = j;
                    }
                }
            }
        }
        
        if(maxX < 0 || maxY < 0) {
            maxX = minX + 1;
            maxY = minY + 1;
            return new int[]{minX, minY, maxX, maxY};
        }
        
        return new int[]{minX, minY, maxX + 1, maxY + 1};
        
    }
}