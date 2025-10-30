import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        
        //Map에 이름 당 그리움 점수 저장
        Map<String, Integer> yearnMap = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            String personName = name[i];
            int personYearn = yearning[i];
            
            yearnMap.put(personName, personYearn);
        }
        
        //사진 속 그리움 점수 계산
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                String photoName = photo[i][j];
                if(yearnMap.containsKey(photoName)) {
                    sum += yearnMap.get(photoName);
                }
            }
            
            answer.add(sum);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}