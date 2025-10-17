import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> userMap = new HashMap<>();
        List<String[]> actions = new ArrayList<>();
        
        
        for(String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String userId = parts[1];
            
            if(command.equals("Enter") || command.equals("Change")) {
                String nickname = parts[2];
                userMap.put(userId, nickname);
            }
            
            if(command.equals("Enter") || command.equals("Leave")) {
                actions.add(new String[]{command, userId});
            }
        }
        
        String[] answer = new String[actions.size()];
        int i = 0;
        for(String[] action : actions) {
            String command = action[0];
            String userId = action[1];
            String nickname = userMap.get(userId);
            
            if(command.equals("Enter")) {
                answer[i++] = nickname + "님이 들어왔습니다.";
            }else {
                answer[i++] = nickname + "님이 나갔습니다.";
            }
        }
        
        
        
        return answer;

    }
    
    
}