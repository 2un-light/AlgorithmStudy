import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int giftCnt = 0;
        
        //직원수만큼 반복
        for(int i = 0; i < schedules.length; i++) {
            int cutOfTime = getTime(schedules[i]);
            int countDay = 0;
            
            for(int j = 0; j < 7; j++) {
                int dayOfweek = (startday + j - 1) % 7 + 1; //1=월 ~ 7=일
                if(dayOfweek == 6 || dayOfweek == 7) continue;
                
                if(timelogs[i][j] <= cutOfTime) {
                    countDay++;
                }
            }
            
            if(countDay == 5) {
                giftCnt++;
            }
            
            
        }
        
        return giftCnt;
        
    }
    
    public int getTime(int time) {
        int hour = time / 100;
        int minute = time % 100 + 10; //10분 추가
        
        if(minute >= 60) {
            minute -= 60;
            hour = hour + 1;
        }
        
        int result = (100 * hour) + minute;
        
        return result;
        
    }
}