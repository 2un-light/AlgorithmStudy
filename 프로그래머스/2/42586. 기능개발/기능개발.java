import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(solution(progresses, speeds));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        List<Integer> days = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            days.add(day);
        }

        int deployDay = days.get(0);
        int count = 1;

        for(int i = 1; i < days.size(); i++) {
            if(days.get(i) <= deployDay) {
                count++;
            }else {
                result.add(count);
                deployDay = days.get(i);
                count = 1;
            }
        }
        result.add(count);

        return result.stream().mapToInt(i -> i).toArray();

    }
}