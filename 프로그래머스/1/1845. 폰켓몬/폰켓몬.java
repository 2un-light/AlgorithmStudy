import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {

        Map<Integer, Integer> pokemons = new HashMap<>();

        for(int num : nums) {
            pokemons.put(num, pokemons.getOrDefault(num, 0) + 1);
        }

        if(pokemons.size() >= nums.length / 2) {
            return nums.length / 2;
        }else {
            return pokemons.size();
        }

    }
}