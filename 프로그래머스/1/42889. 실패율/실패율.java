import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        //각 스테이지에 도달한 사람의 수
        int[] challenge = new int[N + 2];
        
        for(int stage : stages) {
            challenge[stage]++;
        }
        
        int total = stages.length; //전체 플레이어 수
        List<Stage> list = new ArrayList<>();
        
        for(int i = 1; i <= N; i++) {
            if(total == 0) {
                list.add(new Stage(i, 0));
                continue;
            }
            
            float failure = (float) challenge[i] / total;
            list.add(new Stage(i, failure));
            
            total -= challenge[i];
            
        }
        
        list.sort((a, b) -> {
            if(b.failure == a.failure) {
                return a.stageNumber - b.stageNumber;
            }
            return Float.compare(b.failure, a.failure);
        });
        
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = list.get(i).stageNumber;
        }
        
        return answer;
        
       
        
        
    }
    
    //스테이지 번호, 실패율을 담는 클래스
    static class Stage {
        int stageNumber;
        float failure;
        
        Stage(int stageNumber, float failure) {
            this.stageNumber = stageNumber;
            this.failure = failure;
        }
    }
}