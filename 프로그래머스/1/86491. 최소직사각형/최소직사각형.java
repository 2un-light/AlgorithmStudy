import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int n = sizes.length;

        ArrayList<Integer> findMax1 = new ArrayList<>();
        ArrayList<Integer> findMax2 = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                findMax1.add(sizes[i][1]);
                findMax2.add(sizes[i][0]);
            }else {
                findMax1.add(sizes[i][0]);
                findMax2.add(sizes[i][1]);
            }
        }

        Collections.sort(findMax1, Collections.reverseOrder());
        Collections.sort(findMax2, Collections.reverseOrder());

        int result = findMax1.get(0) * findMax2.get(0);

        return result;
    }
}
