import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> people = new HashMap<>();

        for(String player : participant) {
            people.put(player, people.getOrDefault(player, 0) + 1);
        }

        for(String player : completion) {
            people.put(player, people.get(player) - 1);
        }

        for(String name : people.keySet()) {
            if(people.get(name) > 0) {
                return name;
            }
        }


        return "";
    }
}
