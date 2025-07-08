import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(solution(arr));
    }
    public static int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();

        int prev = -1;

        for(int num : arr) {
            if(num != prev) {
                result.add(num);
                prev = num;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
