import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for(String[] c : clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
        }

        int answer = 1;
        for(int count : clothesMap.values()){
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
