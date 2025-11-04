import java.util.*;

class Solution {
    Map<String, Integer> termMap = new HashMap<>();
    int todayYear;
    int todayMonth;
    int todayDay;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        termsToMap(terms);
        
        String[] todaySplit = today.split("\\.");
        todayYear = Integer.parseInt(todaySplit[0]);
        todayMonth = Integer.parseInt(todaySplit[1]);
        todayDay = Integer.parseInt(todaySplit[2]);
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            if(isExpired(privacies[i])) {
                result.add(i + 1);
            }
        }
        
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void termsToMap(String[] terms) {
        for(String term : terms) {
            String[] termSplit = term.split(" ");
            termMap.put(termSplit[0], Integer.parseInt(termSplit[1]));
        }
    }
    
    public boolean isExpired(String privacy) {
        String[] split = privacy.split(" ");
        String[] date = split[0].split("\\.");
        String type = split[1];
        
        int y = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int d = Integer.parseInt(date[2]);
        
        //유효기간
        int addMonth = termMap.get(type);
        int newMonth = m + addMonth;
        
        //날짜 계산
        y += (newMonth - 1) / 12;
        m = newMonth % 12;
        if(m == 0) m = 12;
        
        //날짜는 개인정보 수집일 전날까지 유효
        d -= 1;
        if(d == 0) {
            d = 28;
            m -= 1;
            if(m == 0) {
                m = 12;
                y -= 1;
            }
        }
        
        if(todayYear > y) return true;
        if(todayYear < y) return false;
        if(todayMonth > m) return true;
        if(todayMonth < m) return false;
        return todayDay > d;
        
    }
}